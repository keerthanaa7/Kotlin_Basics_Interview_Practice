package com.example.kotlinbasicsinterviewpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinbasicsinterviewpractice.ui.theme.KotlinBasicsInterviewPracticeTheme

class MainActivity : ComponentActivity() {
    companion object{
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val user1 = User(name = "raghu")
            val user2 = user1.copy(id = 3)
            Log.d(TAG, user1.toString())
            Log.d(TAG, user2.toString())

            val userprofile1 = UserProfile(Profile(Address("kalyani street, kalpakkam")))
            val userprofile2 = UserProfile(Profile(Address(null)))
            val userprofile3 = UserProfile(Profile(null))
            val userprofile4 = UserProfile(null)

            Log.d(TAG, "user profile1 address ${userprofile1.getUserAddress()}")
            Log.d(TAG, "user profile2 address ${userprofile2.getUserAddress()}")
            Log.d(TAG, "user profile3 address ${userprofile3.getUserAddress()}")
            Log.d(TAG, "user profile4 address ${userprofile4.getUserAddress()}")

            val bookReader = BookReader("book title")
            bookReader.printStatus()
            bookReader.bookid = "book id"
            bookReader.printStatus()

            val name = bookReader.bookname
            val area = calculateRadius(2.2)
            Log.d(TAG, "AREA" +area)
            val dog = Dog()
            ProcessAnimalAsDog(dog)
            val cat = Cat()
            ProcessAnimalAsDog(cat)

            val immutablelist :List<String> = listOf("apple", "Banana", "guava")
            Log.d(TAG, "IMMUTABLE LIST ${immutablelist}")

            var mutablelist: MutableList<String> = immutablelist.toMutableList()
            mutablelist.add("cherry")

            Log.d(TAG, "MUTABLE LIST ${mutablelist}")

            val finalimmutablelist:List<String> = mutablelist.toList()
            Log.d(TAG, "FINAL IMMUTABLE LIST ${finalimmutablelist}")
            val dataViewModel:DataViewModel by viewModels()
            dataViewModel.logstateFunction()
            dataViewModel.incrementcounter()
            val result = SealedErrorOPeration();
            result.onSuccess {
                data -> Log.d(TAG, "SUCCESS ${data}")
            }
            result.onFailure {
                action ->
                val error = action as AppError
                when(error){
                    is AppError.Unexpected -> Log.d(TAG, "unexpected error")
                    is AppError.ServerError -> Log.d(TAG, "ServerError")
                    is AppError.Validation -> Log.d(TAG, "Validation")
                }
            }

        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsInterviewPracticeTheme {
        Greeting("Android")
    }
}