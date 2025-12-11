package com.example.kotlinbasicsinterviewpractice

enum class UserStatus(val dbvalue:String) {

    ACTIVE(dbvalue = "ACTIVE"),
    INACTIVE(dbvalue = "INACTIVE"),
    SUSPENDED(dbvalue = "SUSPENDED");
    companion object{
        fun dbtostring( value: String): UserStatus?=
            values().firstOrNull { it.dbvalue == value }
    }
}