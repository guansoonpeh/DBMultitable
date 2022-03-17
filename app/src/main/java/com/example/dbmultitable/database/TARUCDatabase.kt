package com.example.dbmultitable.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dbmultitable.dao.ProgrammeDao
import com.example.dbmultitable.dao.StudentDao
import com.example.dbmultitable.entity.ProgrammeEntity
import com.example.dbmultitable.entity.StudentEntity

@Database(entities = [ProgrammeEntity::class, StudentEntity::class], version = 2, exportSchema = false)
abstract class TARUCDatabase : RoomDatabase(){
    abstract val programmeDao: ProgrammeDao
    abstract val studentDao: StudentDao

    companion object {

        @Volatile
        private var INSTANCE: TARUCDatabase? = null

        fun getInstance(context: Context): TARUCDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TARUCDatabase::class.java,
                        "TARUC_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }
}