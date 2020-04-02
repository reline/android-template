package com.github.reline.androidtemplate.utils

import android.util.Log
import timber.log.Timber

class TestTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        println("${tag ?: "?"}/${priority.toPriority()}: $message ${t ?: ""}")
    }

    private fun Int.toPriority() = when (this) {
        Log.ASSERT -> "A"
        Log.DEBUG -> "D"
        Log.ERROR -> "E"
        Log.INFO -> "I"
        Log.VERBOSE -> "V"
        Log.WARN -> "W"
        else -> this.toString()
    }
}