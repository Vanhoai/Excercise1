package com.dyland.exercise1

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [Student::class],
    version = 2,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            // run migrate add column gender
            override fun migrate(database: SupportSQLiteDatabase) {
                val sql = "ALTER TABLE students ADD COLUMN gender INTEGER NOT NULL DEFAULT 0"
                database.execSQL(sql)
            }
        }
    }

}