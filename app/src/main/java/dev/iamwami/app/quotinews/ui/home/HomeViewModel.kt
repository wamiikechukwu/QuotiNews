package dev.iamwami.app.quotinews.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.iamwami.app.quotinews.db.dao.entity.NewsTable
import dev.iamwami.app.quotinews.db.repo.LocalNewsRepository
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.model.NewsFeed
import dev.iamwami.app.quotinews.network.repo.RemoteNewsRepository
import dev.iamwami.app.quotinews.util.ErrorMessage
import dev.iamwami.app.quotinews.util.ResultWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class HomeViewModel(private val localDbRepository: LocalNewsRepository) : ViewModel() {

    private var _newsResult: MutableStateFlow<ResultWrapper<News>?> = MutableStateFlow(null)
    val newsResult: StateFlow<ResultWrapper<News>?> = _newsResult


    private fun getAllAvailableNews() {

        viewModelScope.launch {

            val response = RemoteNewsRepository().getNews()

            when (response) {
                is ResultWrapper.Loading -> {
                    _newsResult.value = response
                }
                is ResultWrapper.Error -> {
                    _newsResult.value = response
                }
                is ResultWrapper.Success -> {
                    _newsResult.value = response
                }
            }
        }
    }

    val newsFromLocalDb: StateFlow<NewsTable> = localDbRepository.getNews

    fun insertNews(news: NewsTable) {
        viewModelScope.launch {
            localDbRepository.insertNews(news)
        }
    }

    init {
//        Uncomment to start making API calls
//        getAllAvailableNews()
    }

}