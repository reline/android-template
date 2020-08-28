package com.github.reline.androidtemplate.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val message: LiveData<String> = MutableLiveData("Hello World!")
}
