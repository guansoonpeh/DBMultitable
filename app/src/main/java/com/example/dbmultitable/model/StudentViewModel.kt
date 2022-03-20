package com.example.dbmultitable.model

import android.app.Application
import androidx.lifecycle.*
import com.example.dbmultitable.entity.StudentEntity
import com.example.dbmultitable.repository.StudentRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class StudentViewModel(application: Application) : ViewModel(){

    private val repository: StudentRepository
    lateinit var studentList : LiveData<List<StudentEntity>>


    init{
        //Gets reference to UserDao from UserRoomDatabase to construct the correct UserRepository
        repository = StudentRepository(application)

        viewModelScope.launch{
            studentList = repository.getAll()
        }
    }


    fun getAll() {
        viewModelScope.launch {
            studentList =  repository.getAll()
        }
    }


    fun addStudent(student:StudentEntity) {
        viewModelScope.launch {
            repository.add(student)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }


}