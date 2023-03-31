package dev.iamwami.app.quotinews.ui.screens.home

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import dev.iamwami.app.quotinews.model.NewsFeed
import dev.iamwami.app.quotinews.ui.home.NewsChipCategory
import dev.iamwami.app.quotinews.ui.home.NormalNewsSection
import dev.iamwami.app.quotinews.ui.home.PopularNewsSection
import dev.iamwami.app.quotinews.ui.home.RelatedNewsSection
import dev.iamwami.app.quotinews.ui.screens.components.TopBar

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController,
    context: Context,
    openDrawer: () -> Unit = {}
) {

    val newsFeed by homeViewModel.news.collectAsStateWithLifecycle()

    HomeScreen(
        newsFeed = newsFeed,
        onSelectNews = {},
        homeLazyListState = rememberLazyListState(),
        onRefreshNews = { /*TODO*/ },
        onErrorDismissed = {},
        isFavourite = emptySet(),
        scaffoldState = scaffoldState,
        openDrawer = openDrawer,
    )

}


/**
 *Home feed screen displaying just the article feed
 * */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    newsFeed: NewsFeed,
    onSelectNews: (String) -> Unit,
    homeLazyListState: LazyListState,
    onRefreshNews: () -> Unit,
    onErrorDismissed: (Long) -> Unit,
    isFavourite: Set<String>,
    openDrawer: () -> Unit = {},
    scaffoldState: ScaffoldState,

    ) {

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                elevation = if (homeLazyListState.isScrollInProgress) 20.dp else 0.dp,
                openDrawer = openDrawer,
                topBarIcon = Icons.Outlined.Menu,
                topBarTitle = "Quoti News"
            )
        },
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