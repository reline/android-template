package com.github.reline.androidtemplate.di.modules

import com.github.reline.androidtemplate.BuildConfig
import com.github.reline.androidtemplate.utils.AndroidSchedulerProvider
import com.github.reline.androidtemplate.utils.NoOpTree
import com.github.reline.androidtemplate.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module(includes = [
    ViewModelModule::class,
    NetworkModule::class
])
class ApplicationModule {
    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider {
        return AndroidSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideTree(): Timber.Tree {
        return if (BuildConfig.DEBUG) {
            Timber.DebugTree()
        } else {
            NoOpTree()
        }
    }
}