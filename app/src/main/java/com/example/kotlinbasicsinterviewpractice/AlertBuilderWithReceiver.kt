package com.example.kotlinbasicsinterviewpractice

fun BuildAlertWithReceiver(block:Alert.() -> Unit): Alert{
    return Alert().apply(block)

}