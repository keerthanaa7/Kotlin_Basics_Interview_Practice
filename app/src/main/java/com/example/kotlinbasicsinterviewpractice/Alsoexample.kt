package com.example.kotlinbasicsinterviewpractice

import android.util.Log

fun AlsoExample(): Int{
    val list = listOf(10, 20, 30, 40, 50, 60, 70)
    val resultval = list.filter { it>=30 }
        .also { filteredlist ->
            Log.d("AlsoExample ", "filtered list ${filteredlist}" )
        }
        .map { it/5 }
        .also { mappedlist ->
            Log.d("AlsoExample ", "mapped list ${mappedlist}" )
        }
        .sum()
    return resultval
}