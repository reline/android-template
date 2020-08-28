package com.github.reline.androidtemplate.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.reline.androidtemplate.R
import com.github.reline.androidtemplate.persistence.Word

class WordRecyclerViewAdapter : ListAdapter<Word, WordViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.word_layout, parent, false))
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(word: Word) {
        itemView.findViewById<TextView>(R.id.word).text = word.word
    }
}

val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.word == newItem.word
    }
}