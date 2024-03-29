package dev.iamwami.app.quotinews.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.iamwami.app.quotinews.R
import dev.iamwami.app.quotinews.navigation.QuotiNewsNavGraph
import dev.iamwami.app.quotinews.navigation.SplashScreen
import dev.iamwami.app.quotinews.ui.drawer.NavigationDrawer
import dev.iamwami.app.quotinews.ui.screens.home.HomeViewModel
import dev.iamwami.app.quotinews.ui.screens.home.LoadingContent
import dev.iamwami.app.quotinews.ui.theme.Fonts
import dev.iamwami.app.quotinews.ui.theme.QuotiNewsTheme
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotiNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QuotiNewsApp()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun QuotiNewsApp() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = drawerStateForNavigation()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: SplashScreen.route

    val homeViewModel = hiltViewModel<HomeViewModel>()
    val newsFeed by homeViewModel.newsFromDB.collectAsStateWithLifecycle()


    LoadingContent(
        empty = newsFeed.popularNews.isEmpty() && newsFeed.highlightedNews.isEmpty() && newsFeed.recommendedNews.isEmpty() && newsFeed.normalNews.isEmpty(),
        emptyContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),

                //        Use to specify the arrangement of the layout children (inside the layout)
                Arrangement.Center,
//        use to specify the arrangement of the column within the parent
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(id = R.drawable.no_internet_connection),
                    "image to show no internet connection",
                    modifier = Modifier.size(200.dp)
                )

                Text(
                    text = "No internet connection",
                    fontFamily = Fonts.syneFontFamily,
                    modifier = Modifier.padding(top = 20.dp),
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { /*TODO*/ }){
                    Text(text = "Retry")
                }
            }


        },
        content = {
            ModalNavigationDrawer(
                drawerContent = {
                    NavigationDrawer(
                        currentRoute = currentRoute,
                        navigateToHome = { navController.navigate("HomeScreen") },
                        navigateToBookmark = { navController.navigate("BookmarkScreen") },
                        closeDrawer = { coroutineScope.launch { drawerState.close() } }
                    )

                },
                drawerState = drawerState,
            ) {
                QuotiNewsNavGraph(
                    navController = navController,
                    context = LocalContext.current,
                    openDrawer = { coroutineScope.launch { drawerState.open() } },
                    homeViewModel = homeViewModel

                )
            }
        })


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun drawerStateForNavigation() = rememberDrawerState(DrawerValue.Closed)


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuotiNewsTheme {
        QuotiNewsApp()
    }
}