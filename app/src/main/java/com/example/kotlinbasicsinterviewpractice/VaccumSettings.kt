package com.example.kotlinbasicsinterviewpractice

import androidx.compose.runtime.saveable.mapSaver

data class VaccumSettings(val model: String,
    val suctionpower: Int,
    val isenabled: Boolean)


val vaccumsaver = mapSaver(
    save = {mapOf("model" to it.model, "suction" to it.suctionpower, "isenabled" to it.isenabled)},
    restore = { VaccumSettings(model = it["model"] as String, suctionpower = it["suction"] as Int,
        isenabled = it["isenabled"] as Boolean) }
)