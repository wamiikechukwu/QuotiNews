package dev.iamwami.app.quotinews.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import dev.iamwami.app.quotinews.model.NewsFeed

@Composable
fun HomeRoute(
    viewModel: HomeViewModel?,
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController
) {
//    TODO uncomment and fix errors
//    val uiState by HomeViewModel
//    DefaultRoute(
//        uiState = ,
//        newsFeed = ,
//        onToggleLikeButton = ,
//        onSelectNews = ,
//        showTopAppBar = ,
//        onRefreshNews = { /*TODO*/ },
//        onErrorDismissed = ,
//        scaffoldState = ,
//        openDrawer = { /*TODO*/ },
//        onInteractWithFeed = { /*TODO*/ })


    Column() {
        Text(text = "click to run api call")
        Button(onClick = { HomeViewModel() }) {
            Text(text = "Click Me")
        }
        Button(onClick = { Log.d("testing", "BTN clicked") }) {
            Text(text = "test Me")
        }
    }
}

@Composable
fun DefaultRoute(
    uiState: HomeUiState,
    newsFeed: NewsFeed,
    onToggleLikeButton: (String) -> Unit,
    onSelectNews: (String) -> Unit,
    showTopAppBar: Boolean,
    onRefreshNews: () -> Unit,
    onErrorDismissed: (Long) -> Unit,
    scaffoldState: ScaffoldState,
    openDrawer: () -> Unit,
    onInteractWithFeed: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val homeListLazyListState = rememberLazyListState()

    val whichArticleToShouldState = when (uiState) {
        is HomeUiState.HasPost -> uiState.newsFeed.allNews
        is HomeUiState.NoPost -> emptyList()
    }
}