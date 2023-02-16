package dev.iamwami.app.quotinews.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.ui.components.LikeButton
import dev.iamwami.app.quotinews.ui.components.NewsImage
import dev.iamwami.app.quotinews.ui.utils.SampleNewsApiDataProvider

@Composable
fun NormalNews(
    modifier: Modifier = Modifier,
    newsData: News,
    navigateToArticle: (String) -> Unit,
    onToggleFavourite: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        NewsImage(
            newsData = newsData,
            modifier = modifier
                .height(70.dp)
                .width(130.dp)
                .padding(start = 8.dp, end = 12.dp)
        )
        Column(modifier = modifier.weight(1f)) {
            newsData.articles?.get(0)?.let {
                Text(
                    text = it.title,
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Row(modifier = modifier.padding(top = 8.dp)) {
                newsData.articles?.get(0)?.let {
                    Text(
                        style = MaterialTheme.typography.body2,
                        text = it.author,
                    )
                }
                Spacer(modifier = modifier.width(24.dp))
//                TODO Text returns an error
//                Text(
//                    style = MaterialTheme.typography.body2,
//                    text = newsData.articles?.get(0)?.let { dateFormatter(it.publishedAt) }
//                )
            }
        }
        LikeButton()

    }
}

@Preview()
@Composable
fun NewsListPreview(@PreviewParameter(SampleNewsApiDataProvider::class) data: News) {
    NormalNews(newsData = data,
        navigateToArticle = {},
        onToggleFavourite = {})
}
