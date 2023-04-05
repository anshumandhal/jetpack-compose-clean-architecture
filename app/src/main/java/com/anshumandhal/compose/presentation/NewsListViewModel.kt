package com.anshumandhal.compose.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anshumandhal.compose.common.Resource
import com.anshumandhal.compose.remote.model.NewsListState
import com.anshumandhal.compose.use_case.get_news.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    init {
        getNewsList()
    }

    private val _state = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _state

    private fun getNewsList() {
        getNewsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = NewsListState(newsList = result.data?.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = NewsListState(error = result.message ?: "Unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}