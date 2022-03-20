package com.example.dbmultitable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.dbmultitable.database.TARUCDatabase
import com.example.dbmultitable.databinding.ActivityMainBinding
import com.example.dbmultitable.entity.ProgrammeEntity
import com.example.dbmultitable.entity.StudentEntity
import com.example.dbmultitable.model.StudentViewModel
import com.example.dbmultitable.repository.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val programmeDao = TARUCDatabase.getInstance(applicationContext).programmeDao
//        val studentDao = TARUCDatabase.getInstance(applicationContext).studentDao

          val model = StudentViewModel(application)

        model.studentList.observe(this, Observer { list->
            // update view
            var name = ""
            list.forEach(){ student->
                name += student.name + "\n"
            }

            binding.textView.text = name
        })


        binding.btnDelete.setOnClickListener() {
            model.deleteAll()
        }


        binding.btnInsert.setOnClickListener() {

            val student = StudentEntity("W334", "test", "RIT")
            model.addStudent(student)

        }

    }
}