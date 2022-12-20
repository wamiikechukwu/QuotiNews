package dev.iamwami.app.quotinews.network

import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {
    val BASE_URL = "https://newsapi.org/"
    val apikey = "883fcfd667104a34ac74c1827fb419e4"

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // Create Interceptor
    val headerInterceptor = object : okhttp3.Interceptor {
        override fun intercept(chain: okhttp3.Interceptor.Chain): Response {
            var request = chain.request()

            request = request.newBuilder()
                .addHeader("X-Api-Key", apikey)
                .build()

            val response = chain.proceed(request)
            return response
        }
    }

    private val okHttp = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)

    //    retrofit builder
    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttp.build())

    private val builder = retrofitBuilder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return builder.create(serviceType)
    }
}