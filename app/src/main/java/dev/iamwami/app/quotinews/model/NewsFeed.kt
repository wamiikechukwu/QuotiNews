package dev.iamwami.app.quotinews.model

import dev.iamwami.app.quotinews.data.local.entity.NewsTable

/**
 * A container of News partitioned into different categories*/
data class NewsFeed(
    val popularNews: List<NewsTable>,
    val highlightedNews: List<NewsTable>,
    val recommendedNews: List<NewsTable>,
    val normalNews: List<NewsTable>
) {

    /**
     * Returns a list of all other news
     * */
    val allNews: List<NewsTable> = popularNews + highlightedNews + recommendedNews + normalNews
}


