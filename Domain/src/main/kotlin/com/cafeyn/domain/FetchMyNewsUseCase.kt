package com.cafeyn.domain

import com.cafeyn.domain.annotation.CafeynNewsRepository
import com.cafeyn.domain.local.MyNewsCacheRepository
import com.cafeyn.domain.models.MyNews
import com.cafeyn.domain.remote.MyNewsRepository
import javax.inject.Inject

class FetchMyNewsUseCase @Inject constructor(
    @CafeynNewsRepository private val myNewsRepository: MyNewsRepository,
    private val myNewsCacheRepository: MyNewsCacheRepository
) {
    suspend operator fun invoke(): List<MyNews> {
        return try {
            myNewsRepository.fetchMyNews().also {
                myNewsCacheRepository.insertAllNews(it)
            }
        } catch (exception: Exception) {
            myNewsCacheRepository.getMyNews()
        }
    }

}
