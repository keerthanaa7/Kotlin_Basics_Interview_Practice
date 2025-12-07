package com.example.kotlinbasicsinterviewpractice

import android.util.Log

fun ProcessAnimalAsDog(animal: Animal) {
    val dog: Dog? = animal as? Dog

    dog.let { dog ->
            Log.d("ProcessAnimalAsDog" , "dog is not null ")
            dog?.Bark()
        }?: Log.d("ProcessAnimalAsDog" , "dog is null ")
}