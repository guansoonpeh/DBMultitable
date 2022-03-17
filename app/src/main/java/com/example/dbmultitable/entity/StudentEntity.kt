package com.example.dbmultitable.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "student_table",
    foreignKeys =[ForeignKey( entity = ProgrammeEntity::class,
        parentColumns = arrayOf("code"),
        childColumns = arrayOf("programme_code"),
        onDelete = ForeignKey.CASCADE)])

data class StudentEntity(
    @PrimaryKey
    var id: String = "",

    @ColumnInfo(name = "description")
    var name: String="",

    @ColumnInfo(name = "programme_code")
    var programme: String = ""

)

