package dev.iamwami.app.quotinews.db.repo

import dev.iamwami.app.quotinews.db.dao.NewsDao
import dev.iamwami.app.quotinews.db.dao.entity.NewsTable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class LocalNewsRepository(private val newsDao: NewsDao) {

    val getNews: StateFlow<NewsTable> = newsDao.getAllNews()

    fun insertNews(news: NewsTable) {
        newsDao.insertNews(news = news)
    }
}