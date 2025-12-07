package com.example.kotlinbasicsinterviewpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinbasicsinterviewpractice.ui.theme.KotlinBasicsInterviewPracticeTheme

class MainActivity : ComponentActivity() {
    companion object {
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

            var name = bookReader.bookname
            val area = calculateRadius(2.2)
            Log.d(TAG, "AREA" + area)
            val dog = Dog()
            ProcessAnimalAsDog(dog)
            val cat = Cat()
            ProcessAnimalAsDog(cat)

            val immutablelist: List<String> = listOf("apple", "Banana", "guava")
            Log.d(TAG, "IMMUTABLE LIST ${immutablelist}")

            var mutablelist: MutableList<String> = immutablelist.toMutableList()
            mutablelist.add("cherry")

            Log.d(TAG, "MUTABLE LIST ${mutablelist}")

            val finalimmutablelist: List<String> = mutablelist.toList()
            Log.d(TAG, "FINAL IMMUTABLE LIST ${finalimmutablelist}")

            val result1 = PerformDivision(10, 2)
            result1.onSuccess {
                Log.d(TAG, "SUCCESS ${it}")
            }

            val result2 = PerformDivision(10, 0)

            result2.onFailure {
                Log.d(TAG, "FAILURE ${(it as DivisionError).message}")
            }

            val user_1 = User1();
            Log.d(TAG, "user1 " +  user_1.toString())

            val admin = User2(name = "ken", age = 3, email = "ken@gmail.com", false)
            val(newname, newid, newemail, newisactive) =  admin
            Log.d(TAG, "all the newly created variables are name : ${newname}, age: ${newid}, " +
                    "email : ${newemail}, newisactive: ${newisactive}")

            val alsoexamplereturnvalue =AlsoExample()
            Log.d(TAG, "alsoexamplereturnvalue ${alsoexamplereturnvalue}")
            Log.d(TAG, "let example ${LetExample("john")}")
            Log.d(TAG, "let example ${LetExample(null)}")
            val mutablelist1: MutableList<Int> = mutableListOf(10, 5, 20, 5, 30, 5)
            Log.d(TAG, "mutable list ${mutablelist1}")
            mutablelist1.replaceIf({it == 5}, 99)
            Log.d(TAG, "mutable list ${mutablelist1}")
            createCar()
            val criticalalert = BuildAlertWithReceiver{
                title = "alert"
                message = "alert message"
                isurgent == true
                primaryAction = "not ok"
            }
            Log.d(TAG, "critical alert ${criticalalert} ")
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