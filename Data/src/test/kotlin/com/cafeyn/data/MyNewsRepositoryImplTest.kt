package com.cafeyn.data


import com.cafeyn.data.remote.MyNewsApiService
import com.cafeyn.data.remote.MyNewsRepositoryImpl
import com.cafeyn.data.remote.entities.EntityMock
import com.cafeyn.data.remote.mappers.toDomain
import com.cafeyn.domain.remote.MyNewsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class MyNewsRepositoryImplTest {

    private val apiService = mockk<MyNewsApiService>()
    private val repository: MyNewsRepository = MyNewsRepositoryImpl(apiService)

    @Test
    fun `fetch My News`() = runTest {
        // Given
        coEvery { apiService.fetchMyNews() } returns EntityMock.listMyNewsResponse
        // When
        val result = repository.fetchMyNews()
        // Then
        assertEquals(result, EntityMock.listMyNewsResponse.toDomain())
    }

}