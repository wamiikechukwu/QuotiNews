package dev.iamwami.app.quotinews.model

val mockNewsFeed: NewsFeed = NewsFeed(
    popularNews = listOf(news1, news2, news3, news4, news5),
    highlightedNews = listOf(),
    recommendedNews = listOf(),
    normalNews = listOf(news5, news3, news4, news2, news1, news3, news4, news2)
)