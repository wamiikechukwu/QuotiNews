package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.NewsFeed


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
        topBar = { },
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


@RequiresApi(Build.VERSION_CODES.O)
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
            if (newsFeed.popularNews.isNotEmpty()) {
                PopularNewsSection(
                    newsDataList = newsFeed.popularNews,
                    isFavourite = isFavourite,
                    onFavouriteToggle = onToggleFavourite
                )
            }
        }
        itemsIndexed(newsFeed.normalNews) { index, news ->
            if (newsFeed.normalNews.isNotEmpty()) {
                NormalNewsSection(
                    newsData = news,
                    navigateToArticle = onArticleTap,
                    onToggleFavourite = {}
                )
                Log.d("testing", "what index is this $index")
            }
        }


    }
    val showButton by remember {
        derivedStateOf {
            Log.d("testing", "${state.firstVisibleItemIndex}")

        }
    }

    showButton
}



