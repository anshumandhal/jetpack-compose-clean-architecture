package com.anshumandhal.compose.remote.model


import com.google.gson.annotations.SerializedName

data class NewsList(
    @SerializedName("category")
    val category: String,
    @SerializedName("data")
    val `data`: List<NewsItem>,
    @SerializedName("success")
    val success: Boolean
)