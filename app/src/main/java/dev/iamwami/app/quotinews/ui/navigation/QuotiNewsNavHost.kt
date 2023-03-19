package dev.iamwami.app.quotinews.ui.navigation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.iamwami.app.quotinews.ui.bookmark.BookmarkScreen
import dev.iamwami.app.quotinews.ui.home.HomeRoute
import dev.iamwami.app.quotinews.ui.home.HomeViewModel
import dev.iamwami.app.quotinews.ui.splashscreens.NavigateToSplashScreen
import dev.iamwami.app.quotinews.ui.utils.BookmarkScreen
import dev.iamwami.app.quotinews.ui.utils.HomeScreen
import dev.iamwami.app.quotinews.ui.utils.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun QuotiNewsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    context: Context
) {

    NavHost(
        navController = navController,
        startDestination = SplashScreen.route,
        modifier = modifier,
    ) {
        composable(SplashScreen.route) {
            NavigateToSplashScreen(navController)
        }
        composable(HomeScreen.route) {

            val viewModel = hiltViewModel<HomeViewModel>()

            HomeRoute(
                homeViewModel = viewModel,
                openDrawer = { },
                navController = navController,
                context = context
            )
        }
        composable(BookmarkScreen.route){
            BookmarkScreen()
        }
    }
}