package com.example.kotlinbasicsinterviewpractice

data class User(val id: Int = 1,
                var name: String = "John",
                val email:String = "john@gmail.com",
                val isActive: Boolean = false)
