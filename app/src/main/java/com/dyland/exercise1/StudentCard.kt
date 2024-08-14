package com.dyland.exercise1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun StudentCard (student: Student) {
    Text(text = student.name)
}