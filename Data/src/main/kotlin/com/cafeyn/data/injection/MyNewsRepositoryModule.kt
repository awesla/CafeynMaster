package com.cafeyn.data.injection

import com.cafeyn.data.remote.MyNewsApiService
import com.cafeyn.data.remote.MyNewsRepositoryImpl
import com.cafeyn.domain.annotation.CafeynNewsRepository
import com.cafeyn.domain.remote.MyNewsRepository
import com.cafeyn.network.annotation.CafeynRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class MyNewsRepositoryModule {

    @Provides
    @CafeynNewsRepository
    fun provideMyNewsRepository(newsApiService: MyNewsApiService): MyNewsRepository {
        return MyNewsRepositoryImpl(api = newsApiService)
    }

    companion object {
        @Provides
        fun provideMyNewsApiService(@CafeynRetrofit retrofit: Retrofit): MyNewsApiService {
            return retrofit.create(MyNewsApiService::class.java)
        }
    }
}