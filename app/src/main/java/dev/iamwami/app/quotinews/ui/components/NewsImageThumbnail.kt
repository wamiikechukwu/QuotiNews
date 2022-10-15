package dev.iamwami.app.quotinews.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.iamwami.app.quotinews.R
import dev.iamwami.app.quotinews.model.NewsApiResult

//TODO find the best way to work around passing modifier as an arguement.
@Composable
fun NewsImageSmall(
    modifier: Modifier = Modifier,
    newsData: NewsApiResult,
    contentDescription: String = "preview image from the news source"
) {
    AsyncImage(
        model = newsData.articles.post.urlToImage,
        contentDescription = contentDescription,
        modifier = modifier
            .height(200.dp)
            .width(350.dp)
            .clip(shape = MaterialTheme.shapes.medium),
        placeholder = painterResource(id = R.drawable.news_article_image_placeholder_two),
        contentScale = ContentScale.Crop
    )
}