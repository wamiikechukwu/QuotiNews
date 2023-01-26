package dev.iamwami.app.quotinews.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.iamwami.app.quotinews.db.entity.NewsTable
import dev.iamwami.app.quotinews.db.repo.LocalNewsRepository
import dev.iamwami.app.quotinews.model.News
import dev.iamwami.app.quotinews.repo.RemoteNewsRepository
import dev.iamwami.app.quotinews.util.ResultWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    fun insertNews(news: NewsTable) {
        viewModelScope.launch {
            localDbRepository.insertNews(news)
        }
    }

    init {
//        Uncomment to start making API calls
        getAllAvailableNews()
    }

}