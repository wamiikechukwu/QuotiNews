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
    uiState: HomeUiState,
    newsFeed: NewsFeed,
    onToggleLikeButton: (String) -> Unit,
    onSelectNews: (String) -> Unit,
    showTopAppBar: Boolean,
    onRefreshNews: () -> Unit,
    onErrorDismissed: (Long) -> Unit,
    scaffoldState: ScaffoldState,
    modifier: Modifier = Modifier,
    hasNewsContents: @Composable (
        uiState: HomeUiState.HasPost,
        modifier: Modifier
    ) -> Unit
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
        LoadingContent(
            empty = when (uiState) {
                is HomeUiState.HasPost -> false
                is HomeUiState.NoPost -> uiState.isLoading
            }, emptyContent = { LoadingIndicator() },
            loading = uiState.isLoading,
            onRefresh = { onRefreshNews },
            content = {
                when (uiState) {
                    is HomeUiState.HasPost -> hasNewsContents(uiState, innerContentModifier)
                    is HomeUiState.NoPost -> {
                        if (uiState.errorMessage.isEmpty()) {
                            // if there are no posts, and no error, let the user refresh manually
                            TextButton(
                                onClick = onRefreshNews,
                                modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = "Tap to load content",
                                    textAlign = TextAlign.Center
                                )
                            }
                        } else {
                            // there's currently an error showing, don't show any content
                            Box(innerContentModifier.fillMaxSize()) { /* empty screen */ }
                        }
                    }
                }
            })

    }

    // Process one error message at a time and show them as Snackbars in the UI
    if (uiState.errorMessage.isEmpty()) {
// Remember the error message to display on the screen.
        val errorMessage = remember(uiState) {
            uiState.errorMessage[0]
        }

        // Get the text to show on the message from resources
        val errorMessageText: String = errorMessage.errorMessage
        val retryMessageText = "Retry"

        // If onRefreshPosts or onErrorDismiss change while the LaunchedEffect is running,
        // don't restart the effect and use the latest lambda values.
        val onRefreshPostsState by rememberUpdatedState(onRefreshNews)
        val onErrorDismissState by rememberUpdatedState(onErrorDismissed)

        // Effect running in a coroutine that displays the Snackbar on the screen
        // If there's a change to errorMessageText, retryMessageText or scaffoldState,
        // the previous effect will be cancelled and a new one will start with the new values
        LaunchedEffect(key1 = errorMessageText, key2 = retryMessageText, key3 = scaffoldState, block = {
            val snackbarState = scaffoldState.snackbarHostState.showSnackbar(
                message = errorMessageText,
                actionLabel = retryMessageText
            )

            if (snackbarState == SnackbarResult.ActionPerformed) {
                onRefreshPostsState()
            }
            // Once the message is displayed and dismissed, notify the ViewModel
            onErrorDismissState(errorMessage.id)
        })
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

//---
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreenWithArticleDetailsScreen(
    uiState: HomeUiState,
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
    HomeFeedScreenWithNewsList(
        newsFeed = mockNewsFeed,
        onToggleLikeButton = {},
        onSelectNews = {},
        onRefreshNews = {},
        uiState = uiState,
        showTopAppBar = showTopAppBar,
        onErrorDismissed = onErrorDismissed,
        scaffoldState = scaffoldState,
        modifier = modifier,
        hasNewsContents = { hasUiState, contentModifier ->

        })
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsListHomeScreen(newsDataList: List<News>) {
    LazyColumn() {
        items(newsDataList) { newsData ->
//            NewsList(newsData = popularNewsList[0])

        }
    }
}

