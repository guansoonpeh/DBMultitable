package com.example.dbmultitable.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dbmultitable.entity.ProgrammeEntity
import com.example.dbmultitable.entity.StudentEntity

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student: StudentEntity)

    @Query("Delete from student_table")
    suspend fun deleteAll()

    @Query("Select * from student_table")
    fun getAll (): LiveData<List<StudentEntity>>

}