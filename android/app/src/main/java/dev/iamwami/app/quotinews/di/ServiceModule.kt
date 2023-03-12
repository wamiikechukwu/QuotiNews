package dev.iamwami.app.quotinews.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.iamwami.app.quotinews.network.QuotiNewsApiService
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providesQuotiNewsApiService(
        retrofit: Retrofit
    ) : QuotiNewsApiService = retrofit.create()

}