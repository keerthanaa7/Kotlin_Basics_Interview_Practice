package com.example.kotlinbasicsinterviewpractice

data class User3(val id: Int,
    val name: String,
    val age: Int)

fun getAge(age: Int): String{
    val lowerbound = (age / 10) * 10
    val upperbound  = lowerbound + 9
    return "${lowerbound - upperbound}"
}
