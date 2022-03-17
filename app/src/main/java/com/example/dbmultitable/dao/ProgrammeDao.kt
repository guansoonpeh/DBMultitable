package com.example.dbmultitable.dao

import androidx.room.*
import com.example.dbmultitable.entity.ProgrammeEntity

@Dao
interface ProgrammeDao {

    @Insert
    fun insert(pro:ProgrammeEntity)

    @Query("Select * from programme_table")
    fun getAll (): List<ProgrammeEntity>
}