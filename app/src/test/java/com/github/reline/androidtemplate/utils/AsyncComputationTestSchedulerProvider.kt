package com.github.reline.androidtemplate.utils

import io.reactivex.schedulers.Schedulers

class AsyncComputationTestSchedulerProvider : SchedulerProvider {
    override fun newThread() = Schedulers.trampoline()
    override fun single() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
    override fun computation() = Schedulers.computation()
    override fun mainThread() = Schedulers.trampoline()
    override fun trampoline() = Schedulers.trampoline()
}