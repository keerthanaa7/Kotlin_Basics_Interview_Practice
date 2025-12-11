package com.example.kotlinbasicsinterviewpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface UIState<out T>{
    data object Idle: UIState<Nothing>
    data object Loading: UIState<Nothing>
    data class Success<out T>(val data: List<String>): UIState<T>
    data class Error(val message: String): UIState<Nothing>
}

class UserViewModel: ViewModel() {
    private val uistateflow = MutableStateFlow<UIState<List<String>>>(UIState.Idle)
    val uistate= uistateflow.asStateFlow()

    init {

        viewModelScope.launch {
            uistateflow.value = UIState.Loading
            try{
                val users = listOf("apple", "Banana", "guava")
                uistateflow.value = UIState.Success(users)
            }catch (e: Exception){
                uistateflow.value = UIState.Error("error")
            }
        }
    }
}