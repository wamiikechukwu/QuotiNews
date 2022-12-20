package dev.iamwami.app.quotinews.network.repo

import dev.iamwami.app.quotinews.model.Articles
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.model.TestingArticles
import dev.iamwami.app.quotinews.model.TestingNews
import dev.iamwami.app.quotinews.network.QuotiNewsApiService
import dev.iamwami.app.quotinews.network.ServiceBuilder
import dev.iamwami.app.quotinews.util.ResultWrapper
import dev.iamwami.app.quotinews.util.SafeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Call

class RemoteNewsRepository(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    private val apiService by lazy {
        ServiceBuilder.buildService(QuotiNewsApiService::class.java)
    }

    suspend fun getNews(): ResultWrapper<TestingNews> {
//        val queryFilter: MutableMap<String, String> = mutableMapOf()
//        queryFilter.put("q","telsa")

        return SafeApiCall(
            coroutineDispatcher,
            apiCall = {
                      apiService.getNewsByCategory()
            },
        )
    }

//    suspend fun getNews(): TestingNews{
////        val queryFilter: MutableMap<String, String> = mutableMapOf()
////        queryFilter.put("q","telsa")
//
//        val result = apiService.getNewsByCategory()
//
//        return result
//    }

}