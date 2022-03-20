package com.example.dbmultitable.dao

import androidx.room.*
import com.example.dbmultitable.entity.ProgrammeEntity

@Dao
interface ProgrammeDao {

    @Insert
    suspend fun insert(pro:ProgrammeEntity)

    @Query("Select * from programme_table")
    suspend fun getAll (): List<ProgrammeEntity>
}