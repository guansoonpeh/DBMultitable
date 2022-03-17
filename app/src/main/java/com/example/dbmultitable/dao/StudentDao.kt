package com.example.dbmultitable.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dbmultitable.entity.ProgrammeEntity
import com.example.dbmultitable.entity.StudentEntity

@Dao
interface StudentDao {

    @Insert
    fun insert(s: StudentEntity)

    @Query("Select * from student_table")
    fun getAll (): List<StudentEntity>
}