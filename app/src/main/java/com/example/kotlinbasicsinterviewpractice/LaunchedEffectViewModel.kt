package com.example.kotlinbasicsinterviewpractice

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LaunchedEffectViewModel: ViewModel() {
    private var dataMutable: MutableStateFlow<List<String>> = MutableStateFlow<List<String>>(emptyList())
    val data: StateFlow<List<String>> = dataMutable.asStateFlow()

    suspend fun loadData(){
        dataMutable.value = listOf<String>("Apple" , "Banana", "guava")
    }
}