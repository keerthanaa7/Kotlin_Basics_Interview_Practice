package com.example.kotlinbasicsinterviewpractice

fun<T> MutableList<T>.replaceIf(predicate: (T) -> Boolean, newvalue:T){

    val iterator  = this.listIterator()
    while(iterator.hasNext()){
        val element = iterator.next()
        if(predicate(element)){
            iterator.set(newvalue)
        }

    }

}