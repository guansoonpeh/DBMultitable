package com.example.dbmultitable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dbmultitable.database.TARUCDatabase
import com.example.dbmultitable.databinding.ActivityMainBinding
import com.example.dbmultitable.entity.ProgrammeEntity
import com.example.dbmultitable.entity.StudentEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val programmeDao = TARUCDatabase.getInstance(applicationContext).programmeDao
        val studentDao = TARUCDatabase.getInstance(applicationContext).studentDao

        binding.btnInsert.setOnClickListener() {

            CoroutineScope(Dispatchers.IO).launch {
                programmeDao.insert(ProgrammeEntity("RIT", "Mobile App"))
                studentDao.insert(StudentEntity("W123", "John", "RIT"))
            }
        }

    }
}