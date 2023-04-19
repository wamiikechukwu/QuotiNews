package dev.iamwami.app.quotinews.ui.screens.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.iamwami.app.quotinews.data.repository.NewsRepository
import dev.iamwami.app.quotinews.data.repository.OfflineFirstNewsRepository
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.model.NewsFeed
import dev.iamwami.app.quotinews.model.mockNewsFeed
import dev.iamwami.app.quotinews.util.ResultWrapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: OfflineFirstNewsRepository
) : ViewModel() {

    val newsFromDB = newsRepository.getNewsFromDB()
        .map { result ->
            Log.d("testing", "newsFromDB: $result")
            if (result.isNotEmpty()) {
                NewsFeed(
                    popularNews = result,
                    highlightedNews = emptyList(),
                    recommendedNews = emptyList(),
                    normalNews = emptyList()
                )
            } else {
                NewsFeed(
                    popularNews = emptyList(),
                    highlightedNews = emptyList(),
                    recommendedNews = emptyList(),
                    normalNews = emptyList()
                )
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds.inWholeMilliseconds),
            initialValue = mockNewsFeed
        )

}