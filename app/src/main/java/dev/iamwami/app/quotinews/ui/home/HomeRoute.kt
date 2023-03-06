package dev.iamwami.app.quotinews.ui.home

import android.content.Context
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController,
    context: Context
) {

    val newsFeed by homeViewModel.news.collectAsStateWithLifecycle()

    HomeFeedScreenWithNewsList(
        newsFeed = newsFeed,
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