package dev.iamwami.app.quotinews.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.iamwami.app.quotinews.data.NewsRepository
import dev.iamwami.app.quotinews.data.OfflineFirstNewsRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsNewsRepository(
        newsRepository: OfflineFirstNewsRepository
    ) : NewsRepository

}