package dev.iamwami.app.quotinews.data

import dev.iamwami.app.quotinews.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getLatestNews() : Flow<List<News>>

    suspend fun requestNews()

}