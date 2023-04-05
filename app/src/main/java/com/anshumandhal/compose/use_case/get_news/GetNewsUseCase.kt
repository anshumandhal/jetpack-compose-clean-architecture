package com.anshumandhal.compose.use_case.get_news

import com.anshumandhal.compose.common.Resource
import com.anshumandhal.compose.remote.model.NewsItem
import com.anshumandhal.compose.remote.model.NewsList
import com.anshumandhal.compose.remote.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    operator fun invoke() : Flow<Resource<NewsList>> = flow {
        try {
            val newsList = repository.getNewsList()
            emit(Resource.Success(newsList))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check internet connection"))
        }
    }
}