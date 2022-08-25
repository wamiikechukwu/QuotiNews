package dev.iamwami.app.quotinews.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.iamwami.app.quotinews.ui.home.HomeScreen
import dev.iamwami.app.quotinews.ui.splashscreens.SplashScreen
import dev.iamwami.app.quotinews.ui.util.HomeScreen
import dev.iamwami.app.quotinews.ui.util.SplashScreen

@Composable
fun QuotiNewsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = SplashScreen.route,
        modifier = modifier
    ) {
        composable(SplashScreen.route) {
            SplashScreen(
//                TODO
            )
        }
        composable(HomeScreen.route) {
            HomeScreen()
        }
    }
}