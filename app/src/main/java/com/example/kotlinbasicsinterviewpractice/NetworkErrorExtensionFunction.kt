package com.example.kotlinbasicsinterviewpractice

fun Int.toNetworkError(): NetworkError{
    return when(this){
         401 -> NetworkError.InternalError
        402 -> NetworkError.Unauthorized
        403 -> NetworkError.Notfound
        else -> NetworkError.Unknown(this)
    }
}