package com.example.kotlinbasicsinterviewpractice

import android.util.Log

fun<T> Retrylogic(times:Int, block:() -> T):T{
    require(times >= 1){"retry must be atleast 1 "}

    var attempts = 0
    val lastexception: Exception?= null
    while(attempts < times){
        attempts++;
        try{
            return block()
        }catch (e: Exception){
            val remaining = times - attempts
            if(remaining > 0){
                Log.d("RetryExtensionFunction", "retrying")
            }
        }
    }
    throw lastexception?: RuntimeException("RETRY failed")

}