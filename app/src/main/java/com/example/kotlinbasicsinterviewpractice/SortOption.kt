package com.example.kotlinbasicsinterviewpractice

enum class SortOption(val userFriendlyname: String) {
    RECENT(userFriendlyname = "recent"),
    OLD(userFriendlyname = "old"),
    LATEST(userFriendlyname = "latest")
}