package dev.iamwami.app.quotinews.ui.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
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
import dev.iamwami.app.quotinews.ui.utils.SampleNewsApiDataProvider

/**
 * A single UI for the popular news card
 * */
@Composable
fun PopularNews(
    modifier: Modifier = Modifier,
    isIconBookmarked: Boolean,
    iconClicked: () -> Unit,
    newsData: News
) {
    Column(
        modifier = modifier
            .width(350.dp)
    ) {
//            Coil image loader
        AsyncImage(
            model = newsData.articles?.get(0)?.urlToImage,
            contentDescription = "preview image from the news source",
            modifier = modifier
                .height(200.dp)
                .width(350.dp)
                .clip(shape = MaterialTheme.shapes.medium),
            placeholder = painterResource(id = R.drawable.news_article_image_placeholder_two),
            contentScale = ContentScale.Crop
        )
//        News title
        newsData.articles?.get(0)?.let {
            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                text = it.title,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
//        News description
        newsData.articles?.get(0)?.let {
            Text(
                text = it.description,
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
        }
//        Icons row
        Row(
            modifier = modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
        ) {
//            For the new publisher name and date published
            Row {
                newsData.articles?.get(0)?.source?.let {
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.body2,
                        overflow = TextOverflow.Ellipsis, maxLines = 1
                    )
                }
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    /**
                     *TODO uncomment the date formatter
                     **/
                    text = "newsData.articles?.get(0)?.let { dateFormatter(it.publishedAt) }",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }

            Spacer(modifier = modifier.width(16.dp))

//            For the like and share and option menu icon
            Row {

                IconToggleButton(
                    checked = isIconBookmarked,
                    onCheckedChange = { iconClicked() },
                    modifier = modifier.height(20.dp)
//                    onClick = {
//                        Log.d("icon_buttons", "This is bookmarked")
//                    }
                ) {
                    Icon(if (isIconBookmarked) Icons.Outlined.FavoriteBorder else Icons.Filled.FavoriteBorder, contentDescription = "Heart icon for favourite news")
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
        }
    }

}

@Preview()
@Composable
fun PreviewPopularNews(
    @PreviewParameter(
        SampleNewsApiDataProvider::class, 1
    ) data: News
) {
    QuotiNewsTheme {
        Surface() {
            PopularNews(newsData = data,
                isIconBookmarked = false,
                iconClicked = {})
        }
    }
}

