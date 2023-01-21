package dev.iamwami.app.quotinews.db.repo

import dev.iamwami.app.quotinews.db.dao.NewsDao
import dev.iamwami.app.quotinews.db.entity.NewsTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocalNewsRepository(private val newsDao: NewsDao) {

    suspend fun insertNews(news: NewsTable) {
        newsDao.insertNews(news = news)
    }
}