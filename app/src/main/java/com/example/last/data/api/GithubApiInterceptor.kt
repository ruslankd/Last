package com.example.last.data.api

import com.example.last.BuildConfig.GITHUB_USER_NAME
import com.example.last.BuildConfig.GITHUB_USER_PASSWORD
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

object GithubApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("Authorization", Credentials.basic(GITHUB_USER_NAME, GITHUB_USER_PASSWORD))
                .build()
        )

}