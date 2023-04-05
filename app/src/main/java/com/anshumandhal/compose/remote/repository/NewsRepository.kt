package com.anshumandhal.compose.remote.repository

import com.anshumandhal.compose.common.Resource
import com.anshumandhal.compose.remote.model.NewsList
import retrofit2.Response

interface NewsRepository {

    suspend fun getNewsList() : NewsList
}