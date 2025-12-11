package com.example.kotlinbasicsinterviewpractice

fun WithScopeFunction(user: User): String{
    val returnresult: String = with(user){
        name = "john"
        "name ${name}"
    }
    return returnresult

}