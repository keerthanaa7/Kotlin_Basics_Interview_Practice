package com.example.kotlinbasicsinterviewpractice

fun<T, K, V> List<T>.listToMap(keyselector:(T) -> K, valueSelector:(T) ->V): Map<K,V>{

    val mapoutput = LinkedHashMap<K, V>(this.size)
    for(element in this){
        val key = keyselector(element)
        val mapvalue = valueSelector(element)
        mapoutput[key] = mapvalue
    }
    return mapoutput
}