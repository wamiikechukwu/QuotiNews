package dev.iamwami.app.quotinews.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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


@Composable
fun PopularNews(
    modifier: Modifier = Modifier,
    newsData: NewsApiResult
) {
    Column(
        modifier = modifier
            .requiredWidthIn(min = 250.dp, max = 350.dp)
            .padding(start = 8.dp, top = 4.dp),
    ) {
//            Coil image loader
        AsyncImage(
            model = newsData.articles.post.urlToImage,
            contentDescription = "preview image from the news source",
            modifier = modifier
                .heightIn(min = 180.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium),
            placeholder = painterResource(id = R.drawable.news_article_image_placeholder_two),
            contentScale = ContentScale.Fit
        )
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            text = newsData.articles.post.title,
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = newsData.articles.post.author,
            style = MaterialTheme.typography.subtitle2,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

    }
}

@Preview()
@Composable
fun PreviewPopularNews(@PreviewParameter(SampleNewsApiDataProvider::class, 1) data: NewsApiResult) {
    PopularNews(newsData = data)
}

class SampleNewsApiDataProvider : PreviewParameterProvider<NewsApiResult> {
    override val values: Sequence<NewsApiResult> = sequenceOf(
        NewsApiResult(
            status = "ok:200",
            totalResults = "",
            articles = Articles(
                source = Source(
                    id = "",
                    name = ""
                ),
                post = Post(
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