package com.cafeyn.domain.local

import com.cafeyn.domain.models.MyNews
import javax.inject.Inject

class GetMyNewsUseCase @Inject constructor(
    private val myNewsCacheRepository: MyNewsCacheRepository
) {
    suspend operator fun invoke(): List<MyNews> = myNewsCacheRepository.getMyNews()
}
