package com.example.updaterecyclerviewusingdiffutil.repository

import com.example.updaterecyclerviewusingdiffutil.source.NoteDao
import com.example.updaterecyclerviewusingdiffutil.source.entities.Note
import javax.inject.Inject

/**
 * Created by Md. Sabiruzzaman
 * on 7/7/2024.
 */
class NoteRepository @Inject constructor(val dao: NoteDao) {

    suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    suspend fun updateNote(note: Note) {
        dao.updateNote(note)
    }

    fun getNotes() = dao.getNoteList()

}
