package dev.iamwami.app.quotinews.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.iamwami.app.quotinews.navigation.QuotiNewsNavGraph
import dev.iamwami.app.quotinews.navigation.SplashScreen
import dev.iamwami.app.quotinews.ui.drawer.NavigationDrawer
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
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    QuotiNewsApp()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotiNewsApp() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = drawerStateForNavigation()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: SplashScreen.route

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
        )
    }
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