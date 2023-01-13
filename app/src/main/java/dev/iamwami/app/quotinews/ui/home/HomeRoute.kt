package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import dev.iamwami.app.quotinews.model.NewsFeed
import dev.iamwami.app.quotinews.model.mockNewsFeed

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController
) {

    val getNewsDetails by homeViewModel.newsResult.collectAsStateWithLifecycle()
    
    HomeFeedScreenWithNewsList(
        newsFeed = mockNewsFeed ,
        onToggleLikeButton = {},
        onSelectNews = {},
        showTopAppBar = false,
        onRefreshNews = { /*TODO*/ },
        onErrorDismissed = {},
        isFavourite = emptySet(),
        scaffoldState = rememberScaffoldState()

    )

}