package dev.iamwami.app.quotinews.navigation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.iamwami.app.quotinews.ui.home.HomeRoute
import dev.iamwami.app.quotinews.ui.home.HomeViewModel
import dev.iamwami.app.quotinews.ui.screens.bookmark.BookmarkRoute
import dev.iamwami.app.quotinews.ui.screens.splashscreens.NavigateToSplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun QuotiNewsNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = SplashScreen.route,
    context: Context,
    openDrawer: () -> Unit = {}
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(SplashScreen.route) {
            NavigateToSplashScreen(navController)
        }
        composable(HomeScreen.route) {


            val viewModel = hiltViewModel<HomeViewModel>()

            HomeRoute(
                homeViewModel = viewModel,
                navController = navController,
                context = context,
                openDrawer = openDrawer           )


        }
        composable(BookmarkScreen.route) {
            BookmarkRoute(
                navController = navController,
                homeLazyListState = rememberLazyListState(),
                modifier = Modifier,
            )
        }
    }
}