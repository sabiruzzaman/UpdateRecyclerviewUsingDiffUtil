package com.example.updaterecyclerviewusingdiffutil.ui

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.updaterecyclerviewusingdiffutil.R
import com.example.updaterecyclerviewusingdiffutil.databinding.FragmentNoteEntryBinding
import com.example.updaterecyclerviewusingdiffutil.source.entities.Note
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteEntryFragment(private val note: Note?) : DialogFragment(R.layout.fragment_note_entry) {

    private lateinit var binding: FragmentNoteEntryBinding
    private lateinit var currentNote: Note
    private lateinit var viewModel: NoteViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        binding = FragmentNoteEntryBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[NoteViewModel::class.java]
        builder.setView(binding.root)
        builder.setCancelable(false)
        val alertDialog = builder.create()
        alertDialog.setCanceledOnTouchOutside(false)


        binding.apply {

            currentNote = note ?: Note()

            if (currentNote.id != 0) saveOrUpdateBtn.text = "Update"
            else saveOrUpdateBtn.text = "Save"

            binding.titleTv.setText(currentNote.title)
            binding.noteTv.setText(currentNote.note)

            saveOrUpdateBtn.setOnClickListener {
                val titleText = binding.titleTv.text.toString().trim()
                val bodyText = binding.noteTv.text.toString().trim()

                if (titleText.isEmpty() || bodyText.isEmpty()) {
                    Toast.makeText(context, "Title and note cannot be empty.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                currentNote.title = titleText
                currentNote.note = bodyText

                if (currentNote.id == 0) {
                    // insert note into database
                    viewModel.insertNote(currentNote)
                } else {
                    // update note into database
                    viewModel.updateNote(currentNote)
                }
                dismiss()
            }

            // Dialog dismiss
            cancelBtn.setOnClickListener {
                dismiss()
            }
        }
        return alertDialog
    }
}