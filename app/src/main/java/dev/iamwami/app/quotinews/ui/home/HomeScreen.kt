package dev.iamwami.app.quotinews.ui.home

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.NewsFeed


/**
 *Home feed screen displaying just the article feed
 * */
@Composable
fun HomeFeedScreenWithNewsList(
    newsFeed: NewsFeed,
    onToggleLikeButton: (String) -> Unit,
    onSelectNews: (String) -> Unit,
    showTopAppBar: Boolean,
    homeLazyListState: LazyListState,
    onRefreshNews: () -> Unit,
    onErrorDismissed: (Long) -> Unit,
    isFavourite: Set<String>,
    scaffoldState: ScaffoldState,
    modifier: Modifier = Modifier,

    ) {
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            if (showTopAppBar) {
                TopBar(elevation = if (homeLazyListState.isScrollInProgress) 20.dp else 0.dp) {

                }
            }
        },
        bottomBar = { },
        floatingActionButton = {},
    ) { innerPadding ->
        val innerContentModifier = modifier.padding(innerPadding)

//        TODO LoadingContent() should be used when the list is empty


        NewsList(
            newsFeed = newsFeed,
            onToggleFavourite = onToggleLikeButton,
            isFavourite = isFavourite,
            onArticleTap = onSelectNews
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsList(
    newsFeed: NewsFeed,
    onToggleFavourite: (String) -> Unit,
    isFavourite: Set<String>,
    onArticleTap: (String) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 10.dp),
    state: LazyListState = rememberLazyListState(),
) {

    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        state = state,
    ) {

        item {
            NewsChipCategory()
        }
        item {
            if (newsFeed.popularNews.isNotEmpty()) {
                PopularNewsSection(
                    newsDataList = newsFeed.popularNews,
                    isFavourite = isFavourite,
                    onFavouriteToggle = onToggleFavourite
                )
            }
        }
        itemsIndexed(newsFeed.normalNews) { index, news ->

            val showButton by remember {
                derivedStateOf {
                    (index + 1) % 6

                }
            }

            if (newsFeed.normalNews.isNotEmpty()) {
                NormalNewsSection(
                    newsData = news,
                    navigateToArticle = onArticleTap,
                    onToggleFavourite = {}
                )
            }

            if (showButton == 0) {
                RelatedNewsSection(newsData = news)
            }
            Log.d("testing", "index is $showButton")
        }


    }
}






