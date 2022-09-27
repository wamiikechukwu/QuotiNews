package dev.iamwami.app.quotinews.model

data class NewsApiResult(
    val status: String,
    val totalResults: String,
    val articles: Articles
)

data class Articles(
    val source: Source,
    val post: Post
)

data class Source(
    val id: String,
    val name: String
)

data class Post(
    val urlToImage: String,
    val title: String,
    val author: String,
    val description: String,
    val url: String,
    val publishedAt: String,
    val content: String
)
