package com.example.kotlinbasicsinterviewpractice

fun throttle(delay: Long, block:(String) -> Unit): (String) -> Unit{

    val lastexecuted = 0L
    val result = {message: String ->
        val now = System.currentTimeMillis()
        if(now - lastexecuted >= delay){
            block(message)
        }
    }
    return result
}