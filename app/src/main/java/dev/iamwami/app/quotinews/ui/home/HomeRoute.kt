package dev.iamwami.app.quotinews.ui.home

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import dev.iamwami.app.quotinews.db.entity.NewsTable
import dev.iamwami.app.quotinews.db.entity.Source
import dev.iamwami.app.quotinews.model.mockNewsFeed

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController,
    context: Context
) {


        //    TODO CREATE A DIFFERENT COMPOSABLE FOR THIS
        val getNewsDetailsFromRemote by homeViewModel.newsResult.collectAsStateWithLifecycle()
        getNewsDetailsFromRemote?.data?.articles?.forEach { newsArticle ->
            homeViewModel.insertNews(
                NewsTable(
                    source = Source(id = newsArticle.source.id, name = newsArticle.source.name),
                    urlToImage = newsArticle.urlToImage,
                    url = newsArticle.url,
                    author = newsArticle.author,
                    description = newsArticle.description,
                    publishedAt = newsArticle.publishedAt,
                    content = newsArticle.content,
                    title = newsArticle.title
                )
            )
        }


        HomeFeedScreenWithNewsList(
            newsFeed = mockNewsFeed,
            onToggleLikeButton = {},
            onSelectNews = {},
            showTopAppBar = true,
            homeLazyListState = rememberLazyListState(),
            onRefreshNews = { /*TODO*/ },
            onErrorDismissed = {},
            isFavourite = emptySet(),
            scaffoldState = rememberScaffoldState()

        )

}