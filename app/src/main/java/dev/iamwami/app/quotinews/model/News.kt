package dev.iamwami.app.quotinews.model

data class News(
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
    val id: Int,
    val urlToImage: String,
    val title: String,
    val author: String,
    val description: String,
    val url: String,
    val publishedAt: String,
    val content: String
)

//--- TODO use the data class below and later it will be changed

data class TestingNews(
    val status: String,
    val totalResults: Int,
    val articles: List<TestingArticles>
)

data class TestingArticles(
//    val source: TestingSource,
//    val post: Post,
    val source: TestingSource,
    val urlToImage: String,
    val title: String,
    val author: String,
    val description: String,
    val url: String,
    val publishedAt: String,
    val content: String
)

data class TestingSource(
    val id: String,
    val name: String
)

data class TestingPost(
//    val id: Int,
    val source: TestingSource,
    val urlToImage: String,
    val title: String,
    val author: String,
    val description: String,
    val url: String,
    val publishedAt: String,
    val content: String
)

