package com.example.kotlinbasicsinterviewpractice

fun String.toValidationStatus(): ValidationStatus{
    return when{
        this.isBlank() -> ValidationStatus.Invalid("blank password")
        this.length < 8 -> ValidationStatus.Invalid("password less than 8")
        else -> ValidationStatus.Valid
    }
}