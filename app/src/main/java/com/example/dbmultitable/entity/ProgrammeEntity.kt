package com.example.dbmultitable.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "programme_table")

data class ProgrammeEntity (

    @PrimaryKey
    var code: String = "",

    @ColumnInfo(name = "title")
    var title:String = ""

    )