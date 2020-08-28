package com.github.reline.androidtemplate.di.components

import android.app.Application
import androidx.core.view.KeyEventDispatcher
import com.github.reline.androidtemplate.MainActivity
import com.github.reline.androidtemplate.MainApplication
import com.github.reline.androidtemplate.di.modules.ApplicationModule
import com.github.reline.androidtemplate.ui.main.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: MainApplication)
    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
}