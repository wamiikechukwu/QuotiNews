package dev.iamwami.app.quotinews.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.iamwami.app.quotinews.R
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.ui.theme.QuotiNewsTheme
import dev.iamwami.app.quotinews.ui.util.SampleNewsApiDataProvider
import dev.iamwami.app.quotinews.util.dateFormatter

@Composable
fun HighLightedNews(
    modifier: Modifier = Modifier,
    newsData: News
) {
    Column() {
        AsyncImage(
            model = newsData.articles[0].urlToImage,
            contentDescription = "preview image from the news source",
            modifier = modifier
                .height(100.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium),
            placeholder = painterResource(id = R.drawable.news_article_image_placeholder_two),
            contentScale = ContentScale.Crop
        )
        Column(modifier = modifier.padding(16.dp)) {
            Text(
                text = newsData.articles[0].title,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                text = newsData.articles[0].source.name,
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                /**
                 *TODO uncomment the date formatter
                 **/
                text = "dateFormatter(newsData.articles.post.publishedAt)",
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun HighLightedNewsPreview(
    @PreviewParameter(
        SampleNewsApiDataProvider::class, 1
    ) data: News
) {
    QuotiNewsTheme {
        Surface() {
            HighLightedNews(newsData = data)
        }
    }
}