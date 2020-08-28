package com.github.reline.androidtemplate.di.modules

import android.app.Application
import androidx.room.Room
import com.github.reline.androidtemplate.persistence.WordDao
import com.github.reline.androidtemplate.persistence.WordRepository
import com.github.reline.androidtemplate.persistence.WordRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class PersistenceModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): WordRoomDatabase {
        return Room.databaseBuilder(
            application,
            WordRoomDatabase::class.java,
            "word_database"
        ).build()
    }

    @Provides
    @Reusable
    fun provideDao(database: WordRoomDatabase) = database.wordDao()

    @Provides
    @Reusable
    fun provideRepo(dao: WordDao) = WordRepository(dao)
}
