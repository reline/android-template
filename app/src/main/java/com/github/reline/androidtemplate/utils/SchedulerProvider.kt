package com.github.reline.androidtemplate.utils

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun mainThread(): Scheduler
    fun computation(): Scheduler
    fun io(): Scheduler
    fun newThread(): Scheduler
    fun single(): Scheduler
    fun trampoline(): Scheduler
}