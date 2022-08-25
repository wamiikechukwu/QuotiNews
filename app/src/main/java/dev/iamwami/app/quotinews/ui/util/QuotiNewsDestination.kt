package dev.iamwami.app.quotinews.ui.util

interface QuotiNewsDestination {
    val route: String
}

object SplashScreen : QuotiNewsDestination {
    override val route: String
        get() = "SplashScreen"

}

object HomeScreen : QuotiNewsDestination {
    override val route: String
        get() = "HomeScreen"

}