package dev.iamwami.app.quotinews.ui.utils

interface QuotiNewsDestination {
    val route: String
}

object SplashScreen : QuotiNewsDestination {
    override val route: String
        get() = "NavigateToSplashScreen"

}

object HomeScreen : QuotiNewsDestination {
    override val route: String
        get() = "HomeScreen"

}