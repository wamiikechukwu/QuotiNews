package dev.iamwami.app.quotinews.navigation

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

object BookmarkScreen: QuotiNewsDestination {
    override val route: String
        get() = "BookmarkScreen"

}