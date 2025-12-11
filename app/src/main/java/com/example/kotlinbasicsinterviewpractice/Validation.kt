package com.example.kotlinbasicsinterviewpractice

sealed interface ValidationStatus {
    data object Valid: ValidationStatus
    data object Unvalidated: ValidationStatus
    data class Invalid(val message: String): ValidationStatus
}