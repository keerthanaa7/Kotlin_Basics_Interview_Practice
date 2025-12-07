package com.example.kotlinbasicsinterviewpractice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

fun ViewModel.logState() {
    val className = this::class.simpleName
    val properties = this::class.memberProperties
    val logstate = StringBuilder("logging view model ${className}")
    try {
        properties.forEach { property ->
            property.isAccessible = true
            val propertyname = property.name
            val propertyvalue = property.getter.call(this)
            val statevalue = when (propertyvalue) {
                is StateFlow<*> -> "state flow -> ${propertyvalue.value}"
                is LiveData<*> -> "live data -> ${propertyvalue.value}"
                else -> {
                    "$propertyvalue"
                }
            }
            logstate.append(statevalue)
        }
    } catch (e: Exception) {
        logstate.append("unable to log")
    }
    logstate.append("---------------------------\n")
    Log.d("ViewModelLogger", logstate.toString())
}