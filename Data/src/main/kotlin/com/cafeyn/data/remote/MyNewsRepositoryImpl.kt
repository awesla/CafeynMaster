package com.cafeyn.data.remote

import com.cafeyn.data.remote.mappers.toDomain
import com.cafeyn.domain.remote.MyNewsRepository
import javax.inject.Inject

class MyNewsRepositoryImpl @Inject constructor(
    private val api: MyNewsApiService
) : MyNewsRepository {
    override suspend fun fetchMyNews() = api.fetchMyNews().toDomain()
}