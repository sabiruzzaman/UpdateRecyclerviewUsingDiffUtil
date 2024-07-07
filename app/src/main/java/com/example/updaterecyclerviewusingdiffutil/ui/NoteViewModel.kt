package com.example.updaterecyclerviewusingdiffutil.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.updaterecyclerviewusingdiffutil.repository.NoteRepository
import com.example.updaterecyclerviewusingdiffutil.source.entities.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Md. Sabiruzzaman
 * on 7/7/2024.
 */
@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    var notes: LiveData<List<Note>> = repository.getNotes()

    fun insertNote(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }


}
