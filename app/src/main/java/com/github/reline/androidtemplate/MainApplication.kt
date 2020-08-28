package com.github.reline.androidtemplate

import android.app.Application
import com.github.reline.androidtemplate.di.components.ApplicationComponent
import com.github.reline.androidtemplate.di.components.DaggerApplicationComponent
import timber.log.Timber
import javax.inject.Inject

class MainApplication : Application() {

    lateinit var appComponent: ApplicationComponent

    @Inject
    lateinit var tree: Timber.Tree

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)

        Timber.plant(tree)
    }
}