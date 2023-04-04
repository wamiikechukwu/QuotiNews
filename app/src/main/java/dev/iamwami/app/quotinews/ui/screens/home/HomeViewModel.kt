package dev.iamwami.app.quotinews.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.iamwami.app.quotinews.data.repository.NewsRepository
import dev.iamwami.app.quotinews.model.NewsFeed
import dev.iamwami.app.quotinews.model.mockNewsFeed
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    val news = newsRepository.getLatestNews()
        .map { result ->
            /**
             * TODO A DECISION HAS TO BE MADE ABOUT HOW TO MODIFY THE NEW FROM
             *  THE API INTO DIGESTIBLE Contacts.Intents.UI STATE.
             */
            if (result.isNotEmpty()) {
                NewsFeed(
                    popularNews = result,
                    highlightedNews = emptyList(),
                    recommendedNews = emptyList(),
                    normalNews = emptyList()
                )
            } else mockNewsFeed
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds.inWholeMilliseconds),
            initialValue = mockNewsFeed
        )

    fun refreshNews() = viewModelScope.launch {
        newsRepository.requestNewsToLocalDb()
    }
}