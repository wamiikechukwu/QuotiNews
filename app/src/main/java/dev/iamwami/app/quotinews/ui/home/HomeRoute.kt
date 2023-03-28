package dev.iamwami.app.quotinews.ui.home

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.iamwami.app.quotinews.navigation.BookmarkScreen
import dev.iamwami.app.quotinews.navigation.HomeScreen

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

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: HomeScreen.route


    HomeFeedScreenWithNewsList(
        newsFeed = newsFeed,
        onSelectNews = {},
        showTopAppBar = true,
        homeLazyListState = rememberLazyListState(),
        onRefreshNews = { /*TODO*/ },
        onErrorDismissed = {},
        isFavourite = emptySet(),
        scaffoldState = scaffoldState,
        openDrawer = openDrawer,
        currentRoute = currentRoute,
        navigateToBookmark = { navController.navigate(BookmarkScreen.route) },
        navigateToHome = {
            navController.navigate(HomeScreen.route) {
//                navigationActions.navigateToHomeScreenFromNavDrawer
                popUpTo(HomeScreen.route) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        },
//        closeDrawer = {
//            coroutineScope.launch {
//                scaffoldState.drawerState.close()
//            }
//        }
    )

}