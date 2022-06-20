package com.cafeyn.domain.local

import com.cafeyn.domain.MyNews
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class GetMyNewsUseCaseTest {

    private val myNewsCacheRepository = mockk<MyNewsCacheRepository>()
    private val getMyNewsUseCase = GetMyNewsUseCase(myNewsCacheRepository)

    @Test
    fun `fetch My News Use Case`() = runTest {
        // Given
        coEvery { myNewsCacheRepository.getMyNews() } returns MyNews.listNewsItem
        // When
        val result = getMyNewsUseCase.invoke()
        // Then
        assertEquals(result, MyNews.listNewsItem)
    }
}