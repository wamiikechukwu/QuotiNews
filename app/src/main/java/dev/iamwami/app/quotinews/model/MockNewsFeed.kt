package dev.iamwami.app.quotinews.model

val mockNewsFeed: NewsFeed = NewsFeed(
    popularNews = listOf(news1, news2, news3, news4, news5),
    highlightedNews = listOf(news3, news4, news5),
    recommendedNews = listOf(news3, news4, news5),
    normalNews = listOf(news5, news3, news4, news1, news2, news5, news3, news4, news1, news2, news5, news3, news4, news1, news2)
)