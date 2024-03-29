package dev.iamwami.app.quotinews.model

data class News(
    val status: String? = "",
    val totalResults: Int? = 0,
    val articles: List<Articles>? = emptyList()
)

data class Articles(
    val source: Source,
    val urlToImage: String,
    val title: String,
    val author: String,
    val description: String,
    val url: String,
    val publishedAt: String,
    val content: String
)

data class Source(
    val id: String,
    val name: String
)

