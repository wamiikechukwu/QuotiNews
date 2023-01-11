package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.model.NewsFeed
import dev.iamwami.app.quotinews.model.mockNewsFeed
import dev.iamwami.app.quotinews.ui.util.LoadingIndicator


/**
 *Home feed screen displaying just the article feed
 * */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeFeedScreenWithNewsList(
    newsFeed: NewsFeed,
    onToggleLikeButton: (String) -> Unit,
    onSelectNews: (String) -> Unit,
    showTopAppBar: Boolean,
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
            TopAppBar(
                modifier = modifier,
                title = {},
                navigationIcon = {},
                actions = {},
            )
        },
        bottomBar = {},
        floatingActionButton = {},
    ) { innerPadding ->
        val innerContentModifier = modifier.padding(innerPadding)
//        TODO should be used when the list is empty
//        LoadingContent(
//           )

        NewsList(
            newsFeed = newsFeed,
            onToggleFavourite = onToggleLikeButton,
            isFavourite = isFavourite ,
            onArticleTap = onSelectNews)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsList(
    newsFeed: NewsFeed,
    onToggleFavourite: (String) -> Unit,
    isFavourite: Set<String>,
    onArticleTap: (String) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    state: LazyListState = rememberLazyListState(),
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        state = state,
    ) {
        item {
            if (newsFeed.popularNews.isNotEmpty()) {
                PopularNewsSection(
                    newsDataList = newsFeed.popularNews,
                    isFavourite = isFavourite,
                    onFavouriteToggle = onToggleFavourite
                )
            }
            if (newsFeed.normalNews.isNotEmpty()) {
                NormalNewsSection(
                    newsData = newsFeed.normalNews,
                    navigateToArticle = onArticleTap,
                    onToggleFavourite = {}
                )
            }
        }
    }
}

//--- TODO i do not think we need this, its more of a duplication since we
//         we the HomeFeedScreenWithNewsList()
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreenWithArticleDetailsScreen(
    showTopAppBar: Boolean,
    onToggleFavourite: (Int) -> Unit,
    onSelectNews: (String) -> Unit,
    onRefreshNews: () -> Unit,
    onErrorDismissed: (Long) -> Unit,
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState,
    modifier: Modifier = Modifier,
    onSearchInputChanged: () -> Unit
) {
//    HomeFeedScreenWithNewsList(
//        newsFeed = mockNewsFeed,
//        onToggleLikeButton = {},
//        onSelectNews = {},
//        onRefreshNews = {},
//        showTopAppBar = showTopAppBar,
//        onErrorDismissed = onErrorDismissed,
//        scaffoldState = scaffoldState,
//        modifier = modifier,
//    )

}

