package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.iamwami.app.quotinews.R
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.ui.theme.QuotiNewsTheme
import dev.iamwami.app.quotinews.ui.util.SampleNewsApiDataProvider
import dev.iamwami.app.quotinews.util.dateFormatter

/**
 * A single UI for the popular news card
 * */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PopularNews(
    modifier: Modifier = Modifier,
    newsData: News
) {
    Column(
        modifier = modifier
            .width(350.dp)
            .padding(start = 12.dp),
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
//        Icons row
        Row(
            modifier = modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
        ) {
//            For the new publisher name and date published
            Row {
                Text(
                    text = newsData.articles.source.name,
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis, maxLines = 1
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    /**
                     *TODO uncomment the date formatter
                     **/
                    text = dateFormatter(newsData.articles.post.publishedAt),
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }

            Spacer(modifier = modifier.width(16.dp))

//            For the like and share and option menu icon
            Row {
                IconButton(
                    onClick = {
                        Log.d("icon_buttons", "This is bookmarked")
                    }, modifier = modifier.height(20.dp)
                ) {
                    Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Heart icon for favourite news")
                }
                IconButton(
                    onClick = {
                        Log.d("icon_buttons", "This is shared")

                    }, modifier = modifier.height(20.dp)
                ) {
                    Icon(Icons.Filled.Share, contentDescription = "Share icon to share the news")
                }
                IconButton(
                    onClick = {
                        Log.d("icon_buttons", "checked other options")

                    }, modifier = modifier.height(20.dp)
                ) {
                    Icon(Icons.Filled.MoreVert, contentDescription = "Option menu")
                }
            }
        }    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview()
@Composable
fun PreviewPopularNews(
    @PreviewParameter(
        SampleNewsApiDataProvider::class, 1
    ) data: News
) {
    QuotiNewsTheme {
        Surface() {
            PopularNews(newsData = data)
        }
    }
}

