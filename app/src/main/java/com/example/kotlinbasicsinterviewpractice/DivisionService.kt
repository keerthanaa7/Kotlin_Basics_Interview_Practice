package com.example.kotlinbasicsinterviewpractice

data class DivisionError(override val message:String): Throwable()

fun PerformDivision(numerator: Int, denominator: Int): Result<Int>{

    return runCatching {
        if(denominator == 0){
            throw DivisionError("cannot perform division")
        }
        numerator/denominator
    }
}