package com.example.updaterecyclerviewusingdiffutil.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.updaterecyclerviewusingdiffutil.databinding.ActivityMainBinding
import com.example.updaterecyclerviewusingdiffutil.source.NoteDao
import com.example.updaterecyclerviewusingdiffutil.source.entities.Note
import com.example.updaterecyclerviewusingdiffutil.ui.adapter.NoteListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NoteViewModel
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var dao: NoteDao
    private lateinit var adapter: NoteListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]


        // update note item callback listener
        adapter = NoteListAdapter { note ->
            noteEntryDialogFragment(note = note)
        }

        // add new note
        binding.floatingActionButton.setOnClickListener {
            noteEntryDialogFragment()
        }

        getNotes()
    }

    private fun noteEntryDialogFragment(note: Note? = null) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val noteEntryDialogFragment = NoteEntryFragment(note)
        noteEntryDialogFragment.show(fragmentManager, "note_dialog")
    }

    private fun getNotes() {
        viewModel.notes.observe(this) { notes ->
            if (notes != null) {
                if (notes.isEmpty()) {
                    binding.noData.visibility = View.VISIBLE
                } else {
                    binding.noData.visibility = View.GONE
                    binding.noteListRv.adapter = adapter
                    adapter.submitList(notes)
                }
            } else binding.noData.visibility = View.VISIBLE
        }
    }
}