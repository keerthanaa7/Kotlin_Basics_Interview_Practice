package com.example.kotlinbasicsinterviewpractice

import android.util.Log

fun LetExample(name : String?){
     name?.let {
        Log.d("LetExample" , " NAME IS NOT empty")
        val uppercase = it.uppercase()
         return@let uppercase
    }?:run {
        Log.d("lETEXAMPLe" , "name is empty")
        "ken"
    }
}