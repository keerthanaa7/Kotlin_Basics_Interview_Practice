package com.example.kotlinbasicsinterviewpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    private var mutablesharedflowdata: MutableSharedFlow<String>  = MutableSharedFlow<String>(replay = 0)
    val sharedflowdata = mutablesharedflowdata.asSharedFlow()

    fun triggerEvent(){
        viewModelScope.launch {
            mutablesharedflowdata.emit("PROFILE SCREEN")
        }
    }
}