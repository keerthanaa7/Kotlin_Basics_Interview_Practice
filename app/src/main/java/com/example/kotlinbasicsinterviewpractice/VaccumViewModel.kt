package com.example.kotlinbasicsinterviewpractice

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class VaccumViewModel: ViewModel() {
    private var vaccumstatemutable = MutableStateFlow<DialogState>(DialogState.None)
    val vaccumstate = vaccumstatemutable.asStateFlow()

    fun onTriggerEvent(vaccumState: VaccumState){
        when(vaccumState){
            is VaccumState.Togglecleaning ->{}
            is VaccumState.DismissRequested -> {}
            is VaccumState.ErrorOcurred -> {}
        }

    }
}