package com.example.updaterecyclerviewusingdiffutil.source

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.updaterecyclerviewusingdiffutil.source.entities.Note

/**
 * Created by Md. Sabiruzzaman
 * on 7/7/2024.
 */
@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM note")
    fun getNoteList(): LiveData<List<Note>>
}