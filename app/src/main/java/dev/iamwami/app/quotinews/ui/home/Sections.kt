package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.ui.components.PostDivider
import dev.iamwami.app.quotinews.ui.home.components.RelatedNews
import dev.iamwami.app.quotinews.util.Fonts

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PopularNewsSection(
    newsDataList: List<News>,
    isFavourite: Set<String>,
    onFavouriteToggle: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column() {
        Text(
            modifier = modifier.padding(vertical = 16.dp),
            text = "Popular News for you",
            style = MaterialTheme.typography.subtitle1
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(newsDataList) { news ->
                PopularNews(
                    newsData = news,
                    isIconBookmarked = false,
                    iconClicked = { }
                )
            }
        }
        PostDivider()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NormalNewsSection(
    modifier: Modifier = Modifier,
    newsData: News,
    navigateToArticle: (String) -> Unit,
    onToggleFavourite: () -> Unit
) {
    NormalNews(
        newsData = newsData,
        navigateToArticle = navigateToArticle,
        onToggleFavourite = onToggleFavourite
    )
    PostDivider()
}

/*
* This is the Top Bar
* */
@Composable
fun TopBar(
    elevation: Dp,
    openDrawer: () -> Unit,
) {

    val context = LocalContext.current
    TopAppBar(
        title = {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "QuotiNews",
                    fontFamily = Fonts.syneFontFamily
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Functionality not available", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Outlined.Menu, contentDescription = "navigation menu")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Functionality not available", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Outlined.Search, contentDescription = "search icon")
            }
        },

        elevation = elevation,
        backgroundColor = MaterialTheme.colors.surface
    )
}

/*
* This is the related news
* */
@Composable
fun RelatedNewsSection(
    newsData: News,
    modifier: Modifier,
) {
    RelatedNews(newsData = newsData)
}
