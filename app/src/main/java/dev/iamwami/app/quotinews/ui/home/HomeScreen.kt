package dev.iamwami.app.quotinews.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.iamwami.app.quotinews.model.Articles
import dev.iamwami.app.quotinews.model.NewsApiResult
import dev.iamwami.app.quotinews.model.Post
import dev.iamwami.app.quotinews.model.Source

@Preview
@Composable
fun HomeScreen() {
    PopularNews(
        newsData =
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
                    title = "Culinary Inspirations",
                    author = "Inspirations",
                    description = "Culinary",
                    url = "https://appwrite.io/images-ee/1.0/Cover.png",
                    publishedAt = "",
                    content = ""
                )
            )
        )
    )
}