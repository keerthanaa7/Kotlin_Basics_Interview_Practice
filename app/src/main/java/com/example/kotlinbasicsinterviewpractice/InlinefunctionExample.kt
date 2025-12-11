package com.example.kotlinbasicsinterviewpractice

import kotlin.system.measureTimeMillis

inline fun <T: Any> CalculateTime(block: () -> T):T{
    lateinit var result:T
    var timeinms = measureTimeMillis {
        result = block()
    }
    return result
}

fun operation(iterations: Long): Double{
    var sum = 0.0
    for(i in 0 until iterations){
        sum = sum + Math.sqrt(i.toDouble())
    }
    return sum
}