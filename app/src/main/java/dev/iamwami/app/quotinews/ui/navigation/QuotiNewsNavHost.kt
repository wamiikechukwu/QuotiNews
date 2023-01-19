package dev.iamwami.app.quotinews.ui.navigation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.iamwami.app.quotinews.db.AppDatabase
import dev.iamwami.app.quotinews.db.dao.NewsDao
import dev.iamwami.app.quotinews.db.repo.LocalNewsRepository
import dev.iamwami.app.quotinews.ui.home.HomeRoute
import dev.iamwami.app.quotinews.ui.home.HomeViewModel
import dev.iamwami.app.quotinews.ui.splashscreens.NavigateToSplashScreen
import dev.iamwami.app.quotinews.ui.util.HomeScreen
import dev.iamwami.app.quotinews.ui.util.SplashScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun QuotiNewsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    context: Context
) {
    val localDatabase by lazy { AppDatabase.getDatabase(context) }
    val localDbRepository by lazy { LocalNewsRepository(localDatabase.newsDao()) }
    NavHost(
        navController = navController,
        startDestination = SplashScreen.route,
        modifier = modifier,
    ) {
        composable(SplashScreen.route) {
            NavigateToSplashScreen(navController)
        }
        composable(HomeScreen.route) {
//            TODO is this the right way to pass in the view model
            val viewMode = HomeViewModel(localDbRepository)
            HomeRoute(
                homeViewModel = viewMode,
                openDrawer = { },
                navController = navController
            )
        }
    }
}