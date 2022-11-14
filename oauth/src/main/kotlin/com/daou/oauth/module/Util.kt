package com.daou.oauth.module

import com.github.scribejava.core.model.OAuth2AccessToken

class Util {

    /**
     * 텍스트 빌더 결과 반환 메서드
     * @param objs: [Object[]] 객체 가변 인수
     * @return [String] 빌더 결과 문자열
     */
    companion object{
        fun builder(vararg objs: Any?): String {
            val builder = StringBuilder()
            for (obj in objs) {
                builder.append(obj)
            }
            return builder.toString()
        }
    }

    //TODO: yaml 파일을 읽어서 플랫폼 별로 내려주는 value 다르게!
    fun getProperties(platform: String): HashMap<String, String>{
        TODO("Not yet ")
    }
}