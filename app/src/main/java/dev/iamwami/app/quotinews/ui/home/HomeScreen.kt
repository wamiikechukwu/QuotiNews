package dev.iamwami.app.quotinews.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.iamwami.app.quotinews.model.Articles
import dev.iamwami.app.quotinews.model.NewsApiResult
import dev.iamwami.app.quotinews.model.Post
import dev.iamwami.app.quotinews.model.Source

@RequiresApi(Build.VERSION_CODES.O)
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
                    name = "Bloomberg News"
                ),
                post = Post(
                    urlToImage = "https://appwrite.io/images-ee/1.0/Cover.png",
                    title = "Buhari set to go for 3rd term as president klsjalkjd oja jkladi hkaloidh",
                    author = "Wami Ikechukwu",
                    description = "BP and Hertz want to make electric vehicle charging an easier, more" +
                            " enjoyable experience for their customers, " +
                            "car renters, and the general public. " +
                            "Continue reading at TweakTown ",
                    url = "https://appwrite.io/images-ee/1.0/Cover.png",
                    publishedAt = "2022-09-29T04:28:47Z",
                    content = ""
                )
            )
        )
    )


}
