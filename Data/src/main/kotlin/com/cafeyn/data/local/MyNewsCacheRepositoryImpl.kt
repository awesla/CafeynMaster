package com.cafeyn.data.local

import com.cafeyn.data.local.mappers.fromDomain
import com.cafeyn.data.local.mappers.toDomain
import com.cafeyn.domain.local.MyNewsCacheRepository
import com.cafeyn.domain.models.MyNews
import javax.inject.Inject

class MyNewsCacheRepositoryImpl @Inject constructor(
    private val dataBase: CafeynDataBase
) : MyNewsCacheRepository {

    override suspend fun getMyNews() = dataBase.mynewsDao().getAllNews().toDomain()

    override suspend fun insertAllNews(list: List<MyNews>) =
        dataBase.mynewsDao().insertAllNews(list.fromDomain())
}