package dev.iamwami.app.quotinews.data.remote

import dev.iamwami.app.quotinews.model.News
import retrofit2.http.GET

interface ApiService {

    @GET("/v2/everything?q=technology")
    suspend fun getNewsByCategoryTech(): News


    @GET("/v2/everything?q=education")
    suspend fun getNewsByCategoryEdu(): News



    @GET("/v2/everything?q=government")
    suspend fun getNewsByCategoryGovt(): News


    @GET("/v2/everything?q=fashion")
    suspend fun getNewsByCategoryFashion(): News


    @GET("/v2/everything?q=health")
    suspend fun getNewsByCategoryHealth(): News


    @GET("/v2/everything?q=economy")
    suspend fun getNewsByCategoryEcons(): News
}

