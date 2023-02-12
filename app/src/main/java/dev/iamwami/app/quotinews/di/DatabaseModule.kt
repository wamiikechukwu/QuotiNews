package dev.iamwami.app.quotinews.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.iamwami.app.quotinews.db.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesQuotinewDatabase(
        @ApplicationContext context: Context
    ) : AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, "app_database")
        .build()

}