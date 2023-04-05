package com.anshumandhal.compose.remote.repository

import com.anshumandhal.compose.remote.NewsApi
import com.anshumandhal.compose.remote.model.NewsItem
import com.anshumandhal.compose.remote.model.NewsList
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {

    override suspend fun getNewsList(): NewsList {
        return api.getNewsList()
    }
}