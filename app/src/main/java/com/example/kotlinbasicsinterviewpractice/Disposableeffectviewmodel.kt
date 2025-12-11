package com.example.kotlinbasicsinterviewpractice

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel

class Disposableeffectviewmodel: ViewModel() {

    fun trackEvent(event: Lifecycle.Event){
        when(event){
             Lifecycle.Event.ON_START ->{
                 Log.d("Disposableeffectviewmodel", "on start")}
            Lifecycle.Event.ON_CREATE ->  { Log.d("Disposableeffectviewmodel", "on create")}
            Lifecycle.Event.ON_RESUME -> { Log.d("Disposableeffectviewmodel", "on resume")}
            Lifecycle.Event.ON_PAUSE -> { Log.d("Disposableeffectviewmodel", "on pause")}
            Lifecycle.Event.ON_STOP ->    { Log.d("Disposableeffectviewmodel", "on stop")}
            Lifecycle.Event.ON_DESTROY ->  { Log.d("Disposableeffectviewmodel", "on destroy")}
            Lifecycle.Event.ON_ANY ->  { Log.d("Disposableeffectviewmodel", "on destroy")}
        }
    }
}