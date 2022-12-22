package dev.iamwami.app.quotinews.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.model.NewsFeed
import dev.iamwami.app.quotinews.network.repo.RemoteNewsRepository
import dev.iamwami.app.quotinews.util.ErrorMessage
import dev.iamwami.app.quotinews.util.ResultWrapper
import kotlinx.coroutines.launch

sealed interface HomeUiState {
    val isLoading: Boolean
    val errorMessage: List<ErrorMessage>
    val searchInput: String

    data class NoPost(
        override val isLoading: Boolean,
        override val errorMessage: List<ErrorMessage>,
        override val searchInput: String
    ) : HomeUiState

    data class HasPost(
        override val isLoading: Boolean,
        override val errorMessage: List<ErrorMessage>,
        override val searchInput: String,
        val newsFeed: NewsFeed,
        val selectedNews: News,
        val isArticleOpen: Boolean,
        val favourite: Set<String>
    ) : HomeUiState
}

private class HomeViewModelState(
    val newsFeed: NewsFeed? = null,
    val selectedNewsId: String? = null,
    val isArticleOpen: Boolean = false,
    val favourite: Set<String> = emptySet(),
    val isLoading: Boolean = false,
    val errorMessage: List<ErrorMessage> = emptyList(),
    val searchInput: String = ""
) {

    fun toUiState(): HomeUiState =
        if (newsFeed == null) {
            HomeUiState.NoPost(
                isLoading = isLoading,
                errorMessage = errorMessage,
                searchInput = searchInput
            )
        } else {
            HomeUiState.HasPost(
                isLoading = isLoading,
                errorMessage = errorMessage,
                searchInput = searchInput,
                newsFeed = newsFeed,
                selectedNews = newsFeed.allNews.find {
                    it.articles[0].source.id == selectedNewsId
                } ?: newsFeed.normalNews[0],
                isArticleOpen = isArticleOpen,
                favourite = favourite

            )
        }

}

class HomeViewModel() : ViewModel() {

    fun testing(): List<News> {

        val theList = mutableListOf<News>()
        viewModelScope.launch {
//            try {
            val response = RemoteNewsRepository().getNews()
//            Log.d("testing", "view model called with ${i}")
            when (response) {
                is ResultWrapper.Loading -> {
                    Log.d("testing", "loading result ${response.data}")
                }
                is ResultWrapper.Error -> {
                    Log.d("testing", "error result ${response.data}")
                }
                is ResultWrapper.Success -> {
                    Log.d("testing", "success result ${response.data}")

                }
            }
//            theList.add(i)
//            } catch (e: Exception) {
//                Log.d("testing", "prevented app from crashing possible reason $e")
//            }
        }
        return theList
    }

    init {
        testing()
    }

}