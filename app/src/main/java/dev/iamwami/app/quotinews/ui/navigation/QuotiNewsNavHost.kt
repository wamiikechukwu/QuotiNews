package dev.iamwami.app.quotinews.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.iamwami.app.quotinews.ui.home.HomeRoute
import dev.iamwami.app.quotinews.ui.home.HomeScreenWithArticleDetailsScreen
import dev.iamwami.app.quotinews.ui.home.HomeViewModel
import dev.iamwami.app.quotinews.ui.splashscreens.NavigateToSplashScreen
import dev.iamwami.app.quotinews.ui.util.HomeScreen
import dev.iamwami.app.quotinews.ui.util.SplashScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable

fun QuotiNewsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
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
            val viewMode:HomeViewModel? = null
            HomeRoute(
                viewModel = viewMode,
                openDrawer = { },
                navController = navController
            )
        }
    }
}