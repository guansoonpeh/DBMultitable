package com.example.dbmultitable.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.dbmultitable.database.TARUCDatabase
import com.example.dbmultitable.entity.ProgrammeEntity
import com.example.dbmultitable.entity.StudentEntity

class ProgrammeRespository(application: Application) {
    private val programmeDao = TARUCDatabase.getInstance(application).programmeDao

    suspend fun getAll(): LiveData<List<ProgrammeEntity>> {
        return programmeDao.getAll()
    }

    suspend fun add(programme: ProgrammeEntity){
        programmeDao.insert(programme)
    }

}