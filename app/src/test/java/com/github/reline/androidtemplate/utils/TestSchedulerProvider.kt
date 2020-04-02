package com.github.reline.androidtemplate.utils

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulerProvider(private val scheduler: Scheduler = Schedulers.trampoline()) : SchedulerProvider {
    override fun io() = scheduler
    override fun newThread() = scheduler
    override fun single() = scheduler
    override fun computation() = scheduler
    override fun mainThread() = scheduler
    override fun trampoline() = scheduler
}