package dev.iamwami.app.quotinews.data.repository

import androidx.compose.runtime.State
import dev.iamwami.app.quotinews.data.local.entity.NewsTable
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.util.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNewsFromDB() : Flow<List<NewsTable>>

    suspend fun requestNewsToLocalDb()



}