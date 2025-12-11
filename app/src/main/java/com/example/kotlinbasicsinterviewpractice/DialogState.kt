package com.example.kotlinbasicsinterviewpractice

sealed interface DialogState {
    object None: DialogState
    data class Alert(val data: String): DialogState
    data class Action(val actionmessage: String, val func:() -> Unit): DialogState
}

sealed interface VaccumState{
    object Togglecleaning: VaccumState
    data class ErrorOcurred(val code: String): VaccumState
    object DismissRequested: VaccumState
}