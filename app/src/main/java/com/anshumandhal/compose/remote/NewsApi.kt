package com.anshumandhal.compose.remote

import com.anshumandhal.compose.remote.model.NewsList
import retrofit2.http.GET

interface NewsApi {

    @GET("news?category=science")
    suspend fun getNewsList(): NewsList

}