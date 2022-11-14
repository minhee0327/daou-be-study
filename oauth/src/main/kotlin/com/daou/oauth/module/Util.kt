package com.daou.oauth.module

import com.github.scribejava.core.model.OAuth2AccessToken
import java.lang.StringBuilder

class BuilderUtil {

    fun oAuth2Builder(oAuth2AccessToken: OAuth2AccessToken): String {
        val stringBuilder = StringBuilder()
        return stringBuilder.append("?").append(oAuth2AccessToken.accessToken).toString()
    }
}