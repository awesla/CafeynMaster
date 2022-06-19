package com.cafeyn.domain.remote

import com.cafeyn.domain.models.MyNews

interface MyNewsRepository {
    suspend fun fetchMyNews(): List<MyNews>
}