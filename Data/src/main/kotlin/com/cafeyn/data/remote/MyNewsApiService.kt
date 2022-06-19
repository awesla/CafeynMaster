package com.cafeyn.data.remote

import com.cafeyn.data.remote.entities.MyNewsResponse
import retrofit2.http.GET

interface MyNewsApiService {

    @GET("/photos")
    suspend fun fetchMyNews(): List<MyNewsResponse>
}