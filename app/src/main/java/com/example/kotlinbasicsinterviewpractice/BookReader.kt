package com.example.kotlinbasicsinterviewpractice

import android.util.Log

class BookReader(var title : String) {
    companion object{
        const val TAG = "Bookreader"
    }

    lateinit var bookid: String
    val bookname by lazy {
        "book name is book"
    }

    fun printStatus(){
        if(!::bookid.isInitialized){
            Log.d(TAG, "book id not initialzed")
        }else{
            Log.d(TAG, "book id  initialzed")
        }
    }
}