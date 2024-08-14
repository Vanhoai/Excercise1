package com.dyland.exercise1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Student::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}