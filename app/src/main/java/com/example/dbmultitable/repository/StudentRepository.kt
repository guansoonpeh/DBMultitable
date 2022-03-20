package com.example.dbmultitable.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dbmultitable.database.TARUCDatabase
import com.example.dbmultitable.entity.StudentEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudentRepository(application: Application) {
    private val studentDao = TARUCDatabase.getInstance(application).studentDao

    fun getAll(): LiveData<List<StudentEntity>>{
        return studentDao.getAll()
    }

    suspend fun add(student: StudentEntity){
        studentDao.insert(student)

    }

    suspend fun deleteAll(){
        studentDao.deleteAll()

    }
}