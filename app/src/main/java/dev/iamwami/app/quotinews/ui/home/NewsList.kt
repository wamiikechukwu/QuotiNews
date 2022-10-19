package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.iamwami.app.quotinews.model.NewsApiResult
import dev.iamwami.app.quotinews.ui.components.NewsImageSmall
import dev.iamwami.app.quotinews.ui.util.SampleNewsApiDataProvider
import dev.iamwami.app.quotinews.util.dateFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsList(modifier: Modifier = Modifier, newsData: NewsApiResult) {
    Divider(thickness = 1.dp, color = Color.Black)
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        NewsImageSmall(
            newsData = newsData,
            modifier = modifier
                .height(70.dp)
                .width(130.dp)
        )
        NewsListTextBody(data = newsData)
        NewsListLikeBtn()

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsListTextBody(modifier: Modifier = Modifier, data: NewsApiResult) {
    Column {
        Text(
            text = data.articles.post.title,
            style = MaterialTheme.typography.body1
        )
        Row() {
            Text(
                style = MaterialTheme.typography.body2,
                text = data.articles.post.author
            )
            Spacer(modifier = modifier.width(20.dp))
            Text(
                style = MaterialTheme.typography.body2,
                text = dateFormatter(data.articles.post.publishedAt)
            )
        }
    }

}

@Composable
fun NewsListLikeBtn(modifier: Modifier = Modifier) {
    IconButton(
        onClick = {
            Log.d("icon_buttons", "This is bookmarked")
        }
    ) {
        Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Heart icon for favourite news")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    "News List",
    backgroundColor = 0x989a82
)
@Composable
fun NewsListPreview(@PreviewParameter(SampleNewsApiDataProvider::class) data: NewsApiResult) {
    NewsList(newsData = data)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    backgroundColor = 0x989a82,
    showBackground = true
)
@Composable
fun NewsListTextBodyPreview(@PreviewParameter(SampleNewsApiDataProvider::class) data: NewsApiResult) {
    NewsListTextBody(data = data)
}

@Preview(
    backgroundColor = 0x989a82
)
@Composable
fun NewsListLikeBtnPreview() {
    NewsListLikeBtn()
}
