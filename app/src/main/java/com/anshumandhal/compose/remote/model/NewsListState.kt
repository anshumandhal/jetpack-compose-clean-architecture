package com.anshumandhal.compose.remote.model

data class NewsListState(
    val newsList: List<NewsItem> = emptyList(),
    val error: String = ""
)
