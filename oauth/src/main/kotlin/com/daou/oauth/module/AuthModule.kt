package com.daou.oauth.module

import com.daou.oauth.member.UserInfoBean
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.scribejava.core.builder.ServiceBuilderOAuth20
import com.github.scribejava.core.builder.api.DefaultApi20
import com.github.scribejava.core.model.OAuth2AccessToken
import com.github.scribejava.core.model.OAuthRequest
import com.github.scribejava.core.model.Response
import com.github.scribejava.core.model.Verb
import com.github.scribejava.core.oauth.OAuth20Service
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.System.getProperties
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.concurrent.ExecutionException


/**
 * @author mini kang
 *
 * DefaultApi20 추상객체는 2개의 추상메서드가 있고, AuthModule 은 이를 구현할 책임이 있다.
 * 하위 플랫폼 인증 모듈들에 이 책임을 위임할 수 있도록 AuthModule 을 상속하는 하위 플랫폼 인증 모듈에서 구현할 예정
 * 인증 모듈의 핵심 동작음 OAuth20Service 객체로부터 이루어지므로 AuthModule 을 상속할 때 반드시 관련 객체를 받도록 명시하는것이 좋아보인다.

 * @param
 * serviceBuilderOAuth20: OAuth20Service 객체의 빌더
 * unique: String: 인증 모듈의 고유값. 플랫폼의 소문자 표기와 동일 (ex: Naver -> naver)
 */
abstract class AuthModule(
    serviceBuilder: ServiceBuilderOAuth20, unique: String
) : DefaultApi20() {

    //protected -> private
    private var service: OAuth20Service

    private var unique: String

    init {
        //여기서 this 는 DefaultApi20의 구현체 AuthModule
        service = serviceBuilder.build(this)
        this.unique = unique
    }

    /*
    * 인증 URL 반환 메서드
    * 예: 네이버 아이디로 로그인 버튼 클릭시 네이버 로그인 창이 뜨도록하기
    * 플랫폼 로그인창의 URL 을 생성하는 코드
    * state 는 고유 상태값으로 서버에서 임의의 UUID 를 하나 생성해서 사용한다. (뽀안을 위한 세션 체크용)
    * */
    open fun getAuthorizationUrl(state: String?): String? {
        return service.getAuthorizationUrl(state)
    }

    /*
    * 접근 토큰 반환 메서드
    * OAuth2AccessToken: (OAuth2AccessToken: accessToken, refreshToken, token 종류, 유효시간등을 가지는 객체)
    * */
    @Throws(IOException::class, ExecutionException::class, InterruptedException::class)
    open fun getAccessToken(code: String?): OAuth2AccessToken? {
        return service.getAccessToken(code)
    }

    /**
     * service.refreshAccessToken()메서드가 있기는 하지만 getRefreshTokenEndpoint 처리가 플랫폼 별로 달라서
     * HTTPURLConnection 을 활용하여 설계
     */
    @Throws(IOException::class)
    fun getRefreshAccessToken(refresh: String): OAuth2AccessToken {
        val params = HashMap<String, String>()
        params["client_id"] = service.apiKey
        params["client_secret"] = service.apiSecret
        params["refresh_token"] = refresh

        val builder = StringBuilder()
        params.entries.forEach {
            builder
                .append("&").append(URLEncoder.encode(it.key, StandardCharsets.UTF_8))
                .append("=").append(URLEncoder.encode(it.value, StandardCharsets.UTF_8))
        }

        val paramBytes: ByteArray = builder.toString().toByteArray(StandardCharsets.UTF_8)

        val url = URL(refreshTokenEndpoint)

        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.doOutput = true
        connection.outputStream.write(paramBytes)

        val reader = BufferedReader(InputStreamReader(connection.inputStream, StandardCharsets.UTF_8))

        val responseBuilder = StringBuilder()
        var temp: String?
        while (reader.readLine().also { temp = it } != null) {
            responseBuilder.append(temp)
        }
        reader.close()

        val mapper = ObjectMapper()
        val node: JsonNode = mapper.readTree(responseBuilder.toString())
        val accessToken: String = node.get("access_token").textValue()
        val tokenType: String = node.get("token_type").textValue()
        val expiresIn: Int = node.get("expires_in").intValue()
        return OAuth2AccessToken(accessToken, tokenType, expiresIn, null, null, responseBuilder.toString())
    }

    override fun getRefreshTokenEndpoint(): String {
        return Util.builder(accessTokenEndpoint, "?grant_type=refresh_token")
    }

    /*
    * 사용자 정보 응답 반환 메서드
    * Access Token 을 성공적으로 받아왔을 경우 이를 통해 사용자 정보를 불러 올 수 있다.
    * Access Token을 활용하여 해당 플랫폼의 UserInfo API로 요청 보내 응답을 반환한다.
    * */
    @Throws(IOException::class, ExecutionException::class, InterruptedException::class)
    open fun getUserInfo(access: String?): Response? {
        val oAuthRequest = OAuthRequest(Verb.GET, getUserInfoEndPoint())
        service.signRequest(access, oAuthRequest)
        return service.execute(oAuthRequest)
    }

    /*
    * 각 플랫폼의 UserApi URL 을 반환하는 추상메서드로 플랫폼별로 URL 이 다르므로 추상객체로 선언하여 하위 플랫폼 인증 모듈에 구현책임을 위임한다.
    * */
    protected abstract fun getUserInfoEndPoint(): String?

    /*
    * UserInfoBean: MemberDto(UserDto)
    * */
    @Throws(JsonProcessingException::class)
    abstract fun getUserInfoBean(body: String?): UserInfoBean?

    /*
    * 연동 해제 결과 반환 메서드
    * 단순 로그아웃이 아니라 플랫폼과 해당 사용자의 연결을 완전히 파기한다.
    * 이 과정에서 사용자의 관련 데이터 및 정보 제공 동의 이력역시 같이 파기된다.
    * 연동 해제 후 다시 로그인을 하게 되면, 처음 로그인을 수행하는 것처럼 약관과 정보 제공 동의를 다시 선택해야한다.
    * 연동 해제야말로 플랫폼별로 천차만별이므로 추상메서드로 정의한다.
    * */
    @Throws(IOException::class, ExecutionException::class, InterruptedException::class)
    abstract fun deleteInfo(access: String?): Boolean

    /*
    * 정보 제공 동의 갱신 URL 반환 메서드
    * 서비스를 운영하다보면 사용자에게 요구할 정보가 변경되기도 한다.
    * 만약 한참 운영하다가 사용자에게 추가적인 정보를 받아야한다면? 정보를 호출하더라도 동의 내역 자체가 없어 관련정보를 얻어올 수가 없다.
    * 이런 상황에 대비하여 정보 제공 동의를 갱신하는 기능이 필요하다.
    * */
    abstract fun getUpdateAuthorizationUrl(state: String?): String?

    /*
    * API 객체 반환 메서드
    * API 관련 요소를 불러오기위한 메서드가 필요하다.
    * OAuth2.0을 사용하기 위해 필요한 요소 3가지 : API Key, API Secret Key, Callback URL
    * 이를 계속해서 하드코딩하는건 좋지 않다. yaml 파일| properties 파일로 관리해서 WEB-INF/ 아래에서 관리
    * 이렇게 관리하면 gitignore 에 각 플랫폼의 설정파일을 제외해서 GitHub에 올리더라도 해당 파일을 제외하 올린다.
    * 따라서 이렇게 코드를 오픈해도 API 유출을 막을 수가 있다.
    * */
    protected open fun getApiKeyBean(platform: String): ApiKeyBean? {
        val apiKeyBean: ApiKeyBean = ApiKeyBean()

        // API 키 획득 시도
        try {
            val map: HashMap<String, String> = Util().getProperties(platform)
            apiKeyBean.setApi(map["api"])
            apiKeyBean.setSecret(map["secret"])
            apiKeyBean.setCallback(map["callback"])
        } // 예외
        catch (e: Exception) {
            e.printStackTrace()
        }
        return apiKeyBean
    }


}