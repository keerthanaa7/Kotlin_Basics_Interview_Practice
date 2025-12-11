package com.example.kotlinbasicsinterviewpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoadmoreViewModel: ViewModel() {
    private var listdatamutable = MutableStateFlow(List(20){" item ${it}"})
    val listdata: StateFlow<List<String>> = listdatamutable.asStateFlow()

    private var isloadingmutable: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isloading = isloadingmutable.asStateFlow()

    fun fetchNewPage(){
        if(isloadingmutable.value){
            return
        }
        viewModelScope.launch {
            isloadingmutable.value = false;
            val currentsize = listdatamutable.value.size
            delay(2000)
            val newlist = listdatamutable.value + List(20){"item ${it}"}
            listdatamutable.value = newlist
            isloadingmutable.value = true

        }
    }
}