package com.example.room_exam_kotlin

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>

    @Insert
    suspend fun insert(todo : Todo)

    @Update
    suspend fun update(todo : Todo)

    @Delete
    suspend fun delete(todo : Todo)
}