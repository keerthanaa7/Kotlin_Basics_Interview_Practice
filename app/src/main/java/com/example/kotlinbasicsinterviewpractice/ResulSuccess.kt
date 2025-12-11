package com.example.kotlinbasicsinterviewpractice

sealed class ResultSuccess<out V> {
    data class Success<V>(val data:Map<String, V>):ResultSuccess<V>()
    data class Failure(val message: String): ResultSuccess<Nothing>()
}

fun <V> List<Pair<String, V>>.toMapSafely(): ResultSuccess<V>{
    val seenlist = mutableSetOf<String>()
    for((stringkey, _) in this){
        if(seenlist.contains(stringkey)){
            return ResultSuccess.Failure("duplicate key")
        }
        seenlist.add(stringkey)
    }
    return ResultSuccess.Success(this.toMap())


}