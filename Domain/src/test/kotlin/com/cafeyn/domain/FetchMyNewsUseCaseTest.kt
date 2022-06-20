package com.cafeyn.domain

import com.cafeyn.domain.local.MyNewsCacheRepository
import com.cafeyn.domain.remote.MyNewsRepository
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.io.IOException
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class FetchMyNewsUseCaseTest {

    private val newsRepository = mockk<MyNewsRepository>()
    private val myNewsCacheRepository = mockk<MyNewsCacheRepository>()

    private val fetchMyNewsUseCase = FetchMyNewsUseCase(newsRepository, myNewsCacheRepository)

    @Test
    fun `fetch My News Use Case when success`() = runTest {
        // Given
        coEvery { newsRepository.fetchMyNews() } returns MyNews.listNewsItem
        coEvery { myNewsCacheRepository.insertAllNews(any()) } just Runs
        // When
        val result = fetchMyNewsUseCase.invoke()
        // Then
        assertEquals(result, MyNews.listNewsItem)
        coVerify(exactly = 1) { myNewsCacheRepository.insertAllNews(MyNews.listNewsItem) }
    }

    @Test
    fun `fetch My News Use Case when failure`() = runTest {
        // Given
        coEvery { newsRepository.fetchMyNews() } throws IOException()
        coEvery { myNewsCacheRepository.getMyNews() } returns MyNews.listNewsItem
        coEvery { myNewsCacheRepository.insertAllNews(any()) } just Runs
        // When
        val result = fetchMyNewsUseCase.invoke()
        // Then
        assertEquals(result, MyNews.listNewsItem)
        coVerify(exactly = 0) { myNewsCacheRepository.insertAllNews(any()) }
    }
}