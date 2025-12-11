package com.example.kotlinbasicsinterviewpractice

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RoboViewModel(): ViewModel() {
    private var cleaningmutablstate: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)
    val cleaningstate: StateFlow<Boolean> = cleaningmutablstate.asStateFlow()

    fun toggle(){
        cleaningmutablstate.value = !cleaningmutablstate.value
    }
}