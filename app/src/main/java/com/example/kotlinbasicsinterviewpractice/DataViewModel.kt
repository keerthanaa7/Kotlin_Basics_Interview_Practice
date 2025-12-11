package com.example.kotlinbasicsinterviewpractice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


data class UiState(val data:String="",
    val name:String="")

class DataViewModel: ViewModel(){
    companion object{
        private val TAG = "DataViewModel"
    }
    private val datauistateflow = MutableStateFlow(UiState())
    val uistate = datauistateflow.asStateFlow()

    private val datauilivedata:MutableLiveData<Int> = MutableLiveData<Int>(0)
    val livedata:LiveData<Int> = datauilivedata

    val simpleProperty:String = "data view model"
    init {


    }

    fun logstateFunction(){
        viewModelScope.launch {
            try {
                logState()
                val uistate = UiState("data", "name")
                datauistateflow.value = uistate
                datauilivedata.value = 1
            }catch (e:Exception){
                Log.d(TAG, "unable to log ")
            }
            logState()
        }
    }

    fun incrementcounter(){
        logState()
        datauilivedata.value = (datauilivedata.value?:0)+1
        logState()
    }

}