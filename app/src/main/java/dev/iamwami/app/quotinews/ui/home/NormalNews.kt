package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
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
import dev.iamwami.app.quotinews.ui.components.NewsImageSmall
import dev.iamwami.app.quotinews.ui.components.NewsListLikeBtn
import dev.iamwami.app.quotinews.ui.util.SampleNewsApiDataProvider
import dev.iamwami.app.quotinews.util.dateFormatter

@RequiresApi(Build.VERSION_CODES.O)
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
        NewsImageSmall(
            newsData = newsData,
            modifier = modifier
                .height(70.dp)
                .width(130.dp)
                .padding(start = 8.dp, end = 12.dp)
        )
        Column(modifier = modifier.weight(1f)) {
            Text(
                text = newsData.articles.post.title,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Row(modifier = modifier.padding(top = 8.dp)) {
                Text(
                    style = MaterialTheme.typography.body2,
                    text = newsData.articles.post.author,
                )
                Spacer(modifier = modifier.width(24.dp))
                Text(
                    style = MaterialTheme.typography.body2,
                    text = dateFormatter(newsData.articles.post.publishedAt)
                )
            }
        }
        NewsListLikeBtn()

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview()
@Composable
fun NewsListPreview(@PreviewParameter(SampleNewsApiDataProvider::class) data: News) {
    NormalNews(newsData = data,
        navigateToArticle = {},
        onToggleFavourite = {})
}
