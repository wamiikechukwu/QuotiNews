package dev.iamwami.app.quotinews.data.repository

import dev.iamwami.app.quotinews.data.local.entity.NewsTable
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getLatestNews() : Flow<List<NewsTable>>

    suspend fun requestNews()

}