package com.example.kotlinbasicsinterviewpractice

import android.util.Log

data class Car(var color:String, val model: String, val makeyear:Int)

fun createCar(){
    val car = Car(color = "red", model = "toyota", makeyear = 1990)
    Log.d("CarClass" , "car object " + car.toString())
    car.apply {
        color ="yellow"
    }.also {
        Log.d("CarClass" , "car object " + car.toString())
    }
}

