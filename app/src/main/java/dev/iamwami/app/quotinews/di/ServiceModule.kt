package dev.iamwami.app.quotinews.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.iamwami.app.quotinews.data.remote.ApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providesQuotiNewsApiService(
        retrofit: Retrofit
    ) : ApiService = retrofit.create(ApiService::class.java)

}