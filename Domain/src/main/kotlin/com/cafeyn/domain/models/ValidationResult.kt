package com.cafeyn.domain.models

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: DataErrorMessage? = null
)