package com.dyland.exercise1

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
import androidx.room.Room
import com.dyland.exercise1.ui.theme.Exercise1Theme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var database: AppDatabase
    private lateinit var studentDao: StudentDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercise1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "AppDatabase"
        ).build()

        studentDao = database.studentDao()

        GlobalScope.launch {
            studentDao.insert(Student(name = "Trần Văn Hoài", age = 21, address = "Đà Nẳng"))
            studentDao.insert(Student(name = "Tăng Hồng Nguyên Đán", age = 22, address = "An Giang"))
            studentDao.insert(Student(name = "Võ Ngọc Min Kiên", age = 21, address = "Gia Lai"))

            val students = studentDao.getAllStudents()
            students.forEach {
                Log.d("MainActivity", "Student: $it")
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