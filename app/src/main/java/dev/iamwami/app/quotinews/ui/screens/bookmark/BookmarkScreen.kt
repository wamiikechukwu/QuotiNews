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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.iamwami.app.quotinews.ui.screens.components.TopBar

// create a composable function called BookmarkRoute and call BookmarkScreen inside it
@Composable
fun BookmarkRoute(
    modifier: Modifier = Modifier,
    homeLazyListState: LazyListState,
    navController: NavHostController
) {
    BookmarkScreen(
        modifier = modifier,
        homeLazyListState = homeLazyListState,
        navController = navController
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarkScreen(
    modifier: Modifier = Modifier,
    homeLazyListState: LazyListState,
    navController: NavHostController
) {
    Scaffold(modifier = modifier,
        topBar = {
            TopBar(elevation = if (homeLazyListState.isScrollInProgress) 20.dp else 0.dp,
                topBarTitle = "BookMarks",
                topBarIcon = Icons.Outlined.Menu,
                openDrawer = { })
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

//create a composable function called BookmarkContent and call BookmarkList inside it
@Composable
fun BookmarkContent(
    modifier: Modifier
) {
    BookmarkList(modifier)
}

@Composable
fun BookmarkList(modifier: Modifier) {
    Column(modifier) {
    }
}
