package dev.iamwami.app.quotinews.data

import dev.iamwami.app.quotinews.db.dao.NewsDao
import dev.iamwami.app.quotinews.db.entity.NewsTable
import dev.iamwami.app.quotinews.db.entity.Source
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.network.QuotiNewsApiService
import dev.iamwami.app.quotinews.util.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class OfflineFirstNewsRepository @Inject constructor(
    private val newsDao: NewsDao,
    private val apiService: QuotiNewsApiService,
    private val coroutineDispatcher: CoroutineDispatcher
) : NewsRepository{

    override fun getLatestNews(): Flow<List<News>> = newsDao
        .fetchAllNews()
        .map { cachedResult ->
            //TODO determine how newsTable should be converted into news
            cachedResult.map { news ->
                News()
            }
        }
        .onStart { requestNews() }


    override suspend fun requestNews() {
        safeApiCall(
            coroutineDispatcher,
            apiCallFunction = {
                apiService.getNewsByCategory()
            }
        ).data?.articles?.map { article ->

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

        }?.let { newsArticles ->
            newsDao.insertNews(newsArticles)
        }
    }

}