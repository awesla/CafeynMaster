package com.cafeyn.domain

import io.mockk.mockk
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidateNewsDataUseCaseTest {

    private val validateNewsDataUseCase = ValidateNewsDataUseCase()

    @Test
    fun `the input is null, returns error`() {
        val result = validateNewsDataUseCase.invoke(null)
        assertFalse(result.successful)
    }

    @Test
    fun `the input is empty, returns error`() {
        val result = validateNewsDataUseCase.invoke(emptyList())
        assertFalse(result.successful)
    }

    @Test
    fun `the input is valid list, returns valid`() {
        val result = validateNewsDataUseCase.invoke(MyNews.listNewsItem)
        assertTrue(result.successful)
    }
}