package dev.iamwami.app.quotinews.ui.screens.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.iamwami.app.quotinews.R
import dev.iamwami.app.quotinews.ui.screens.components.TopBar

@Composable
fun BookmarkRoute(
    modifier: Modifier = Modifier,
    homeLazyListState: LazyListState,
    navController: NavHostController,
    openDrawer: () -> Unit = {},
) {
    BookmarkScreen(
        modifier = modifier,
        homeLazyListState = homeLazyListState,
        navController = navController,
        openDrawer = { openDrawer() }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarkScreen(
    modifier: Modifier = Modifier,
    homeLazyListState: LazyListState,
    navController: NavHostController,
    openDrawer: () -> Unit = {},
) {
    Scaffold(modifier = modifier,
        topBar = {
            TopBar(elevation = if (homeLazyListState.isScrollInProgress) 20.dp else 0.dp,
                topBarTitle = stringResource(R.string.bookmark),
                topBarIcon = Icons.Outlined.Menu,
                openDrawer = { openDrawer() }
            )
        },
        content = { innerPadding ->
            BookmarkContent(
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.primary)
            )
        }
    )
}

@Composable
fun BookmarkContent(
    modifier: Modifier
) {
    Column(modifier) {
    }
}
