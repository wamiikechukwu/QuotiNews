package dev.iamwami.app.quotinews.network

import dev.iamwami.app.quotinews.BuildConfig
import dev.iamwami.app.quotinews.model.Articles
import dev.iamwami.app.quotinews.model.News
import retrofit2.Call
import retrofit2.http.GET

interface QuotiNewsApiService {



    //    https://newsapi.org/v2/everything?q=tesla&apiKey=883fcfd667104a34ac74c1827fb419e4
//    https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=883fcfd667104a34ac74c1827fb419e4
//    search query - keyword, date published, source domain name and language
//    keyword, sortBy
    @GET("/v2/everything?q=tesla")
    suspend fun getNewsByCategory(): News
//    suspend fun getNewsByCategory(@QueryMap filter: Map<String, String>?): News
}

//https://newsapi.org/everything?q=tesla&apiKey=883fcfd667104a34ac74c1827fb419e4
//https://newsapi.org/v2/everything?q=tesla&from=2022-11-16&sortBy=publishedAt&apiKey=883fcfd667104a34ac74c1827fb419e4