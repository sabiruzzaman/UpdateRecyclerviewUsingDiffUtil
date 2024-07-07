package com.example.updaterecyclerviewusingdiffutil.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.updaterecyclerviewusingdiffutil.databinding.ItemNoteBinding
import com.example.updaterecyclerviewusingdiffutil.source.entities.Note

/**
 * Created by Md. Sabiruzzaman
 * on 7/7/2024.
 */
class NoteListAdapter(val itemClickedCallBack: (Note) -> Unit) :
    ListAdapter<Note, NoteListAdapter.NotsListViewHolder>(NoteItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(inflater, parent, false)
        return NotsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NotsListViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Note) {

            // data set in view
            binding.titleTv.text = item.title
            binding.noteTv.text = item.note

            // update item
            binding.root.setOnClickListener {
                itemClickedCallBack(item)
            }
        }
    }

}

