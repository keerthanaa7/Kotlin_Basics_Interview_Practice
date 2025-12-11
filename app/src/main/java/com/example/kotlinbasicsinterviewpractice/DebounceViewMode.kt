package com.example.kotlinbasicsinterviewpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.time.debounce

class DebounceViewMode: ViewModel() {

    val searchquery = MutableStateFlow("")
     val debouncedresult = searchquery.debounce(500L).distinctUntilChanged().stateIn(scope =
     viewModelScope, started = SharingStarted.WhileSubscribed(5000),
         "")
}