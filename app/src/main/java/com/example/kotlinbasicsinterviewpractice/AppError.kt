package com.example.kotlinbasicsinterviewpractice

import androidx.core.app.NotificationCompat.MessagingStyle.Message

sealed class AppError(override val message: String,
                      open val code: Int):Exception(message) {


    data class Validation(
        override val message: String,
        override val code: Int = 400,
        val field: String
    ) : AppError(message, code)

    data class ServerError(
        override val message: String,
        override val code: Int = 500
    ) : AppError(message, code)

    data class Unexpected(
        override val message: String,
        override val code: Int = 999
    ) : AppError(message, code)
}