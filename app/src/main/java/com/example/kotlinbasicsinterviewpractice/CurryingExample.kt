package com.example.kotlinbasicsinterviewpractice

fun MultiplyCurryingExample(a: Int):(Int) -> Int{
    return fun(b: Int): Int{
        return a * b
    }
}