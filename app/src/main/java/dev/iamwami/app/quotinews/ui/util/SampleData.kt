package dev.iamwami.app.quotinews.ui.util

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.iamwami.app.quotinews.model.Articles
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.model.Source

class SampleNewsApiDataProvider : PreviewParameterProvider<News> {
    override val values: Sequence<News> = sequenceOf(
        News(
            status = "ok:200", totalResults = 85, articles = listOf(
                Articles(
                    source = Source(
                        id = "1", name = ""
                    ),
                    urlToImage = "https://appwrite.io/images-ee/1.0/Cover.png",
                    title = "Buhari set to go for 3rd term as president\"",
                    author = "Wami",
                    description = "Culinary",
                    url = "https://appwrite.io/images-ee/1.0/Cover.png",
                    publishedAt = "",
                    content = "",

                    )
            )
        )
    )
}