package com.example.kotlinbasicsinterviewpractice

fun runfunction(user: User): String{
    return user.run {
        name = "keer"
        "user name is ${name}"
    }
}