package dev.iamwami.app.quotinews.model

/**
 * A container of News partitioned into different categories*/
data class NewsFeed(
    val popularNews: List<News>,
    val highlightedNews: List<News>,
    val recommendedNews: List<News>,
    val normalNews: List<News>
)


