package com.example.kotlinbasicsinterviewpractice

import kotlin.random.Random

fun SealedErrorOPeration():Result<String>{
    val randomvalue:Int = Random.nextInt(0, 100)
    return when{
        randomvalue <20 -> Result.failure(AppError.Validation("validation error", 400, ""))
        else -> Result.failure(AppError.Unexpected("unexpected error", 999))
    }

}