package com.example.kotlinbasicsinterviewpractice

data class Alert(
    var title: String="",
    var message: String="",
    val isurgent: Boolean = true,
    var primaryAction: String = "OK")
