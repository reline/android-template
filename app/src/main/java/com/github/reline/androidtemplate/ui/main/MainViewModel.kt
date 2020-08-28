package com.github.reline.androidtemplate.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.reline.androidtemplate.persistence.Word
import com.github.reline.androidtemplate.persistence.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val wordRepo: WordRepository
) : ViewModel() {
    val allWords: LiveData<List<Word>> = wordRepo.allWords

    fun onSubmitClicked(input: String) = viewModelScope.launch(Dispatchers.IO) {
        wordRepo.insert(Word(input))
    }
}
