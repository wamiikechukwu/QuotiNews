package dev.iamwami.app.quotinews.network

import dev.iamwami.app.quotinews.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {
    private const val BASE_URL = "https://newsapi.org/"

    private val apiKey: String
        get() = BuildConfig.API_KEY

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // Create Interceptor
    private val headerInterceptor = Interceptor { chain ->
        var request = chain.request()

        request = request.newBuilder()
            .addHeader("X-Api-Key", apiKey)
            .build()

        val response = chain.proceed(request)
        response
    }

    private val okHttp = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)

    //    retrofit builder
    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttp.build())

    private val builder = retrofitBuilder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return builder.create(serviceType)
    }
}