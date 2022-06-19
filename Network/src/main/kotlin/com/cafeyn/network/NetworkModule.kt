package com.cafeyn.network

import com.cafeyn.core.preferences.ISharedPreferencesManager
import com.cafeyn.core.utils.BASE_URL_PREFS_KEY
import com.cafeyn.network.annotation.CafeynOkhhtp
import com.cafeyn.network.annotation.CafeynRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @CafeynOkhhtp
    fun provideCafeynApiOkHttpClient(
        sentCookiesInterceptor: SentCookiesInterceptor,
        receivedCookiesInterceptor: ReceivedCookiesInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(sentCookiesInterceptor)
            .addInterceptor(receivedCookiesInterceptor)
            .addNetworkInterceptor { chain ->
                val request = chain.request()
                val newUrl = request.url.newBuilder().build()
                val newRequest = request.newBuilder().url(newUrl).build()

                chain.proceed(newRequest)

            }.build()
    }

    @Provides
    @CafeynRetrofit
    fun provideRetrofit(
        @CafeynOkhhtp okHttpClient: OkHttpClient,
        sharedPreferences: ISharedPreferencesManager
    ): Retrofit {
        val baseUrl = sharedPreferences
            .readFromSharedPreferences(BASE_URL_PREFS_KEY to "") as String

        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
}