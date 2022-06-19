package com.cafeyn.domain

import com.cafeyn.domain.annotation.CafeynNewsRepository
import com.cafeyn.domain.models.MyNews
import com.cafeyn.domain.remote.MyNewsRepository
import javax.inject.Inject

class FetchMyNewsUseCase @Inject constructor(
    @CafeynNewsRepository private val myNewsRepository: MyNewsRepository
) {
    suspend operator fun invoke(): List<MyNews> {
        return myNewsRepository.fetchMyNews()
    }

}
