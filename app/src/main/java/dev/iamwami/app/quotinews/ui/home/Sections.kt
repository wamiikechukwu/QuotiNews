package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.ui.components.PostDivider

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PopularNewsSection(
    newsDataList: List<News>,
    isFavourite: Set<String>,
    onFavouriteToggle: (String) -> Unit,
) {
    Column(modifier = Modifier.padding(end = 16.dp)) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Popular News for you",
            style = MaterialTheme.typography.subtitle1
        )
        LazyRow {
            items(newsDataList) { news ->
                PopularNews(
                    newsData = news,
                    isIconBookmarked = false,
                    iconClicked = { }
                )
            }
        }
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
