package dev.iamwami.app.quotinews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dev.iamwami.app.quotinews.ui.navigation.QuotiNewsNavHost
import dev.iamwami.app.quotinews.ui.theme.QuotiNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotiNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
//    TODO check if Scaffold is needed to hold the NavHost

    QuotiNewsNavHost(
        navController = navController,
        modifier = Modifier
    )

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuotiNewsTheme {
        App()
    }
}