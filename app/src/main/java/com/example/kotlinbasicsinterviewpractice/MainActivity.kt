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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinbasicsinterviewpractice.ui.theme.KotlinBasicsInterviewPracticeTheme
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.sign
import kotlin.system.measureTimeMillis

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

            val dog = Dog()
            ProcessAnimalAsDog(dog)
            val cat = Cat()
            ProcessAnimalAsDog(cat)

            val result1 = PerformDivision(10, 2)
            result1.onSuccess {
                Log.d(TAG, "SUCCESS ${it}")
            }

            val result2 = PerformDivision(10, 0)

            result2.onFailure {
                Log.d(TAG, "FAILURE ${(it as DivisionError).message}")
            }

            val user_1 = User1();
            Log.d(TAG, "user1 " + user_1.toString())

            val admin = User2(name = "ken", age = 3, email = "ken@gmail.com", false)
            val (newname, newid, newemail, newisactive) = admin
            Log.d(
                TAG, "all the newly created variables are name : ${newname}, age: ${newid}, " +
                        "email : ${newemail}, newisactive: ${newisactive}"
            )

            val alsoexamplereturnvalue = AlsoExample()
            Log.d(TAG, "alsoexamplereturnvalue ${alsoexamplereturnvalue}")
            Log.d(TAG, "let example ${LetExample("john")}")
            Log.d(TAG, "let example ${LetExample(null)}")
            val mutablelist1: MutableList<Int> = mutableListOf(10, 5, 20, 5, 30, 5)
            Log.d(TAG, "mutable list ${mutablelist1}")
            mutablelist1.replaceIf({ it == 5 }, 99)
            Log.d(TAG, "mutable list ${mutablelist1}")
            createCar()
            val criticalalert = BuildAlertWithReceiver {
                title = "alert"
                message = "alert message"
                isurgent == true
                primaryAction = "not ok"
            }
            Log.d(TAG, "critical alert ${criticalalert} ")


            val result = SealedErrorOPeration();
            result.onSuccess { data ->
                Log.d(TAG, "SUCCESS ${data}")
            }
            result.onFailure { action ->
                val error = action as AppError
                when (error) {
                    is AppError.Unexpected -> Log.d(TAG, "unexpected error")
                    is AppError.ServerError -> Log.d(TAG, "ServerError")
                    is AppError.Validation -> Log.d(TAG, "Validation")
                }
            }
            val user = User()
            val returnval = runfunction(user)
            Log.d(TAG, "return val ${returnval}")
            val withreturnval = WithScopeFunction(user)
            Log.d(TAG, "return val ${withreturnval}")
            val userViewModel: UserViewModel by viewModels()
            /*  runBlocking {
                  userViewModel.uistate.collect { value ->
                      when(val state = value){
                          is UIState.Idle -> Log.d(TAG, "IDLE")
                          is UIState.Error -> Log.d(TAG, "ERROR ${state.message}")
                          is UIState.Loading -> Log.d(TAG, "loading ")
                          is UIState.Success -> Log.d(TAG, "success ${state.data.size}")
                      }
                  }
              }*/

            val dbvalue: String = "INACTIVE"
            val userStatus: UserStatus? = UserStatus.dbtostring(dbvalue)
            Log.d(TAG, "user status ${userStatus}")
            val statucode1: Int = 401
            Log.d(TAG, "network error ${statucode1.toNetworkError()}")
            val list = listOf("short", "thisisalongpassword", "Valid123Password", "")
            for (password in list) {
                val status: ValidationStatus = password.toValidationStatus()
                when (status) {
                    is ValidationStatus.Valid -> Log.d(TAG, "valid status")
                    else -> Log.d(TAG, "unknown")
                }
            }
            val maxretries = 4
            var successonattempt = 3
            var count = AtomicInteger(0)
            Retrylogic(maxretries) {
                val currentattempt = count.incrementAndGet()
                if (currentattempt < successonattempt) {
                    throw IllegalArgumentException()
                }

                Log.d(TAG, "success")
            }
            val productlist = listOf<Product>(
                Product("sku1", "name1", 0.9),
                Product("sku2", "name2", 0.8),
                Product("sku3", "name3", 0.7)
            )
            val finalmap =
                productlist.listToMap(keyselector = { it.name }, valueSelector = { it.id })
            Log.d(TAG, "final map ${finalmap}")
            val finalresult = MultiplyCurryingExample(5)(7)
            Log.d(TAG, "final result ${finalresult}")
            val count1 = 200L
            var resultime = CalculateTime {
                operation(count1)
            }
            Log.d(TAG, "result time ${resultime}")
            fun logtime(data: String) {
                val time = System.currentTimeMillis() % 1000
                Log.d(TAG, "time : ${time} , data : ${data}")
            }

            val throttlefunction = throttle(1000L, ::logtime)
            throttlefunction("call 1")
            for (i in 0..10) {
                throttlefunction("call ${i} is skipped")
                Thread.sleep(100)
            }
            val inputlist = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            val evennumberlist = inputlist.filter(::isEven)
            Log.d(TAG, "EVEN LIST ${evennumberlist}")
            val squaredlist = evennumberlist.map(::square)
            Log.d(TAG, "squared list ${squaredlist}")
            val productlist1 = listOf<ProductDto>(
                ProductDto(1, "product1", true),
                ProductDto(2, "product2", false),
                ProductDto(3, "product3", true)
            )

            val filteredlist = productlist1.filter { it -> it.instock }
            Log.d(TAG, "filtered list ${filteredlist}")
            val mappedlist = filteredlist.map { it ->
                val pricename = it.name
                "price name ${pricename}"
            }
            Log.d(TAG, "mappedlist ${mappedlist}")

            val foldedval = filteredlist.fold(0) { total, product ->
                total + product.id
            }
            Log.d(TAG, "folded value ${foldedval}")
            val user3list = listOf<User3>(
                User3(1, "user1", 10),
                User3(2, "user2", 20)
            )
            val groupmaplist = user3list.groupBy { user ->
                getAge(user.age)
            }
            Log.d(TAG, "group map ${groupmaplist}")
            for ((age, agelist) in groupmaplist) {
                Log.d(TAG, "key is age ${age}")
                for (individualage in agelist) {
                    Log.d(TAG, "each age is ${individualage}")
                }
            }

            val mapinput = mapOf<String, Int>(
                "one" to 1,
                "two" to 2,
                "three" to 3
            )
            val outputmap = mapinput.mapValues { (_, number) -> number + 1 }
            for ((numberstring, numberval) in outputmap) {
                Log.d(TAG, "KEY ${numberstring}")
                Log.d(TAG, "value ${numberval}")
            }
            val departmentlistnested = listOf<Department>(
                Department(
                    name = "department1", skillslist = listOf(
                        "kotlin",
                        "java", "python"
                    )
                ),
                Department("department2", skillslist = listOf("c", "kotlin"))
            )

            val flatlist = departmentlistnested.flatMap { department ->
                department.skillslist
            }
            for (department in flatlist) {
                Log.d(TAG, "DEpartment ${department}")
            }
            val resultset = flatlist.toSet()
            for (finaldept in resultset) {
                Log.d(TAG, "final dep ${finaldept}")
            }
            val pagesize = 5
            val datalist = (1..22).map { num -> Item(num, "num") }
            val outputlist = paginate(datalist, pagesize)
            val firstlist = outputlist.get(0)
            for (item in firstlist) {
                Log.d(TAG, "item ${item}")
            }
            val secondlist = outputlist.getOrNull(1)
            secondlist?.forEach { it ->
                Log.d(TAG, "second list item ${it}")
            }

            val inputlist5 = listOf(
                "one" to 1,
                "two" to 2,
                "three" to 3,
                "four" to 4
            )
            val duplicateinputlist = listOf(
                "one" to 1,
                "two" to 2,
                "one" to 1,
                "three" to 3
            )
            val resultmapsafety = inputlist5.toMapSafely()
            when (resultmapsafety) {
                is ResultSuccess.Success -> {
                    Log.d(TAG, "result success")
                    val resultmap = resultmapsafety.data
                    for ((mapkey, mapvalue) in resultmap) {
                        Log.d(TAG, "key ${mapkey} value ${mapvalue}")
                    }
                }
                is ResultSuccess.Failure ->  Log.d(TAG, "result failure")
            }
            val size = 100000
            val performanceinputlist = (1..size).toList()
            val collectiontime = measureTimeMillis {
                val outputlist = performanceinputlist.filter(::examplefilterfunc)
                    .map(::examplemapfunction)
                    .take(10)
                Log.d(TAG, "output list size ${outputlist.size}")
            }

            Log.d(TAG, "Collectiontim ${collectiontime}")

            val collectiontime2 = measureTimeMillis {
                val outputseq = performanceinputlist.asSequence().filter(::examplefilterfunc)
                    .map(::examplemapfunction)
                    .take(10)
                    .toList()
                Log.d(TAG, "output seq size ${outputseq.size}")
            }
            Log.d(TAG, "Collectiontim ${collectiontime2}")
            val inputlist4 = listOf<User4>(User4(1, "user1", "milpitas"),
                User4(2, "user2", "santcaclara"),
                    User4(3, "user3", "sanjose"))
            val outputmap4 = inputlist4.associateBy { it -> it.id }
            for((key4, value4) in outputmap4){
                Log.d(TAG, "key4 ${key4}")
                Log.d(TAG, "values ${value4}")
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