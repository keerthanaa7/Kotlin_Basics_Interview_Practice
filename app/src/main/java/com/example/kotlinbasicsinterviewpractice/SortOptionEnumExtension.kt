package com.example.kotlinbasicsinterviewpractice

import android.util.Log

fun getSortOptionList(): List<String>{
    return SortOption.entries.map { it.userFriendlyname }
}

fun printSort(option: SortOption){
    when(option){
        SortOption.OLD -> Log.d("SORT OPTION ","old" )
        SortOption.LATEST -> Log.d("SORT OPTION ","LATEST" )
        SortOption.RECENT -> Log.d("SORT OPTION ","RECENT" )
    }
}

