package dev.iamwami.app.quotinews.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.iamwami.app.quotinews.db.AppDatabase
import dev.iamwami.app.quotinews.db.dao.NewsDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun providesNewsDao(
        database: AppDatabase
    ) : NewsDao = database.newsDao()

}