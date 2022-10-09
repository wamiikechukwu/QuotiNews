package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.iamwami.app.quotinews.R
import dev.iamwami.app.quotinews.model.Articles
import dev.iamwami.app.quotinews.model.NewsApiResult
import dev.iamwami.app.quotinews.model.Post
import dev.iamwami.app.quotinews.model.Source
import dev.iamwami.app.quotinews.util.Formatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PopularNews(
    modifier: Modifier = Modifier, newsData: NewsApiResult
) {
    Column(
        modifier = modifier
            .width(350.dp)
            .padding(start = 12.dp, top = 18.dp),
    ) {
//            Coil image loader
        AsyncImage(
            model = newsData.articles.post.urlToImage,
            contentDescription = "preview image from the news source",
            modifier = modifier
                .height(200.dp)
                .width(350.dp)
                .clip(shape = MaterialTheme.shapes.medium),
            placeholder = painterResource(id = R.drawable.news_article_image_placeholder_two),
            contentScale = ContentScale.Crop
        )
//        News title
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            text = newsData.articles.post.title,
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
//        News description
        Text(
            text = newsData.articles.post.description,
            style = MaterialTheme.typography.body2,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )
        PopularNewsBottomRow(newsData)
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PopularNewsBottomRow(
    newsData: NewsApiResult,
    iconModifier: Modifier = Modifier.height(20.dp),
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
    ) {
//            For the new publisher name and date published
        Row(
        ) {
            Text(
                text = newsData.articles.source.name,
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis, maxLines = 1
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = Formatter.dateFormatter(newsData.articles.post.publishedAt),
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }

        Spacer(modifier = modifier.width(16.dp))

//            For the like and share and option menu icon
        Row(
        ) {
            IconButton(
                onClick = {
                    Log.d("icon_buttons", "This is bookmarked")
                }, modifier = iconModifier
            ) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Heart icon for favourite news")
            }
            IconButton(
                onClick = {
                    Log.d("icon_buttons", "This is shared")

                }, modifier = iconModifier
            ) {
                Icon(Icons.Filled.Share, contentDescription = "Share icon to share the news")
            }
            IconButton(
                onClick = {
                    Log.d("icon_buttons", "checked other options")

                }, modifier = iconModifier
            ) {
                Icon(Icons.Filled.MoreVert, contentDescription = "Option menu")
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewPopularNews(
    @PreviewParameter(
        SampleNewsApiDataProvider::class, 1
    ) data: NewsApiResult
) {
    PopularNews(newsData = data)
}

class SampleNewsApiDataProvider : PreviewParameterProvider<NewsApiResult> {
    override val values: Sequence<NewsApiResult> = sequenceOf(
        NewsApiResult(
            status = "ok:200", totalResults = "", articles = Articles(
                source = Source(
                    id = "", name = ""
                ), post = Post(
                    urlToImage = "https://appwrite.io/images-ee/1.0/Cover.png",
                    title = "Buhari set to go for 3rd term as president\"",
                    author = "Wami Ikechukwu",
                    description = "Culinary",
                    url = "https://appwrite.io/images-ee/1.0/Cover.png",
                    publishedAt = "",
                    content = ""
                )
            )
        )
    )
}
