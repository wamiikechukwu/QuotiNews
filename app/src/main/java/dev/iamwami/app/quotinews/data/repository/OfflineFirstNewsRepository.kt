package dev.iamwami.app.quotinews.data.repository

import dev.iamwami.app.quotinews.data.remote.ApiService
import dev.iamwami.app.quotinews.data.local.dao.NewsDao
import dev.iamwami.app.quotinews.data.local.entity.NewsTable
import dev.iamwami.app.quotinews.data.local.entity.Source
import dev.iamwami.app.quotinews.util.ResultWrapper
import dev.iamwami.app.quotinews.util.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class OfflineFirstNewsRepository @Inject constructor(
    private val newsDao: NewsDao,
    private val apiService: ApiService,
    private val coroutineDispatcher: CoroutineDispatcher
) : NewsRepository {

    override fun getLatestNews(): Flow<List<NewsTable>> = newsDao.fetchAllNews()
        .map { localData ->
            localData.map { news ->
                NewsTable(
                    id = 1,
                    source = Source(
                        id = news.source.id,
                        name = news.source.name
                    ), urlToImage = news.urlToImage,
                    title = news.title,
                    author = news.author,
                    description = news.description,
                    url = news.url,
                    publishedAt = news.publishedAt,
                    content = news.content
                )
            }
        }
        .onStart { requestNews() }


    override suspend fun requestNews() {
        safeApiCall(
            coroutineDispatcher,
            apiCallFunction = {
                apiService.getNewsByCategoryTech()
            }
        ).also {
            when (it) {
                is ResultWrapper.Success -> {
                    it.data?.articles?.map { article ->
                        NewsTable(
                            source = Source(
                                id = article.source.id,
                                name = article.source.name
                            ),
                            urlToImage = article.urlToImage,
                            url = article.url,
                            author = article.author,
                            description = article.description,
                            publishedAt = article.publishedAt,
                            content = article.content,
                            title = article.title
                        )
                    }?.let { articleList ->
                        newsDao.insertNews(articleList)
                    }
                }
                is ResultWrapper.Error -> {}
                is ResultWrapper.Loading -> {}
            }
        }
    }

}