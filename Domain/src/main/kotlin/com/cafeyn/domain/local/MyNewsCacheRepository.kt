package com.cafeyn.domain.local

import com.cafeyn.domain.models.MyNews

interface MyNewsCacheRepository {
    suspend fun getMyNews(): List<MyNews>
    suspend fun insertAllNews(list: List<MyNews>)
}