package com.dyland.exercise1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    suspend fun insert(student: Student)

    @Query("DELETE FROM students WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM students")
    suspend fun getAllStudents(): List<Student>
}