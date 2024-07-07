package com.example.updaterecyclerviewusingdiffutil.source.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "note")
    var note: String = ""
)
