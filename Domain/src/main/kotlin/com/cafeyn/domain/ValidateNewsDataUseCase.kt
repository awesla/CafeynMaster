package com.cafeyn.domain

import com.cafeyn.domain.models.DataErrorMessage
import com.cafeyn.domain.models.MyNews
import com.cafeyn.domain.models.ValidationResult
import javax.inject.Inject

class ValidateNewsDataUseCase @Inject constructor() {
    fun invoke(list: List<MyNews>?): ValidationResult {
        if (list.isNullOrEmpty()) {
            return ValidationResult(
                successful = false,
                errorMessage = DataErrorMessage.EMPTY_DATA
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}