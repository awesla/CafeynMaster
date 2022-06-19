package com.cafeyn.network

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.net.ssl.SSLException

class SentCookiesInterceptor @Inject constructor(
    @ApplicationContext private val context: Context
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            val requestBuilder = chain.request().newBuilder()
            chain.proceed(requestBuilder.build())
        } catch (e: SSLException) {
            throw IOException("SSL ERROR CUSTOM FROM AddCookiesInterceptor")
        }
    }
}
