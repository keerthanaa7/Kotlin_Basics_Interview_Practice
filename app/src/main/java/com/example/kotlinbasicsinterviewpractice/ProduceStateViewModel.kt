package com.example.kotlinbasicsinterviewpractice

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class ProduceStateViewModel : ViewModel() {

    val coldvalue = flow {
        for (i in 1..100) {
            emit(i)
            delay(1000)

        }
    }
}