package dev.iamwami.app.quotinews.ui.screens.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.NewsFeed
import dev.iamwami.app.quotinews.ui.home.NewsChipCategory
import dev.iamwami.app.quotinews.ui.home.NormalNewsSection
import dev.iamwami.app.quotinews.ui.home.PopularNewsSection
import dev.iamwami.app.quotinews.ui.home.RelatedNewsSection
import dev.iamwami.app.quotinews.ui.screens.components.TopBar


/**
 *Home feed screen displaying just the article feed
 * */
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeFeedScreenWithNewsList(
    newsFeed: NewsFeed,
    onSelectNews: (String) -> Unit,
    showTopAppBar: Boolean,
    homeLazyListState: LazyListState,
    onRefreshNews: () -> Unit,
    onErrorDismissed: (Long) -> Unit,
    isFavourite: Set<String>,
    currentRoute: String,
    openDrawer: () -> Unit = {},
    navigateToHome: () -> Unit,
    navigateToBookmark: () -> Unit,
    scaffoldState: ScaffoldState,
    modifier: Modifier = Modifier,

    ) {

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
//            if (showTopAppBar) {
                TopBar(
                    elevation = if (homeLazyListState.isScrollInProgress) 20.dp else 0.dp,
                    openDrawer = openDrawer,
                    topBarIcon = Icons.Outlined.Menu,
                    topBarTitle = "Quoti News"
                )
//            }
        },
        bottomBar = { },
        floatingActionButton = {},
        content = { innerPadding ->
            val innerContentModifier = modifier.padding(innerPadding)

//        TODO LoadingContent() should be used when the list is empty


            NewsList(
                newsFeed = newsFeed,
                isFavourite = isFavourite,
                onArticleTap = onSelectNews
            )
        }
    )
}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsList(
    newsFeed: NewsFeed,
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
                    onFavouriteToggle = remember { mutableStateOf(true) }
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
                    onToggleFavourite = remember { mutableStateOf(true) }
                )
            }

            if (showButton == 0) {
                RelatedNewsSection(newsData = news,
                    onToggleLikeBtn = remember { mutableStateOf(true) })
            }
            Log.d("testing", "index is $showButton")
        }


    }
}





