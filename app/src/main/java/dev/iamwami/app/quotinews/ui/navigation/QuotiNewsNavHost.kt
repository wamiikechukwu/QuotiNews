package dev.iamwami.app.quotinews.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.iamwami.app.quotinews.ui.home.HomeRoute
import dev.iamwami.app.quotinews.ui.home.HomeViewModel
import dev.iamwami.app.quotinews.ui.splashscreens.NavigateToSplashScreen
import dev.iamwami.app.quotinews.ui.utils.HomeScreen
import dev.iamwami.app.quotinews.ui.utils.SplashScreen

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
    }
}