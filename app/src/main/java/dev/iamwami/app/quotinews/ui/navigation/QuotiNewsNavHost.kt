package dev.iamwami.app.quotinews.ui.navigation

import android.os.Build
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.iamwami.app.quotinews.ui.home.HomeScreen
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
//            BackHandler() {
//                Log.d("testing","back button pressed")
//            }
        }
        composable(HomeScreen.route) {
            HomeScreen()
        }
    }
}