package com.example.kotlinbasicsinterviewpractice

data class Item(val id: Int,
    val name: String)

fun paginate(inputdata:List<Item>, pagesize: Int):List<List<Item>>{
    return inputdata.chunked(pagesize)
}
