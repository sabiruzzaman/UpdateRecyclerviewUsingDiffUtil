package com.example.updaterecyclerviewusingdiffutil.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.updaterecyclerviewusingdiffutil.source.entities.Note

/**
 * Created by Md. Sabiruzzaman
 * on 7/7/2024.
 */
class NoteItemDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}