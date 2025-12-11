package com.example.kotlinbasicsinterviewpractice

sealed interface NetworkError {
    data object Unauthorized: NetworkError
    data object Notfound: NetworkError
    data object InternalError: NetworkError
    data class Unknown(val code:Int): NetworkError
}