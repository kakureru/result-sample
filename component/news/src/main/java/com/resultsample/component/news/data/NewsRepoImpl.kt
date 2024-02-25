package com.resultsample.component.news.data

import com.resultsample.common.core.DataLoss
import com.resultsample.common.core.GenericError
import com.resultsample.common.core.ResultState
import com.resultsample.component.news.NewsRepo
import com.resultsample.component.news.model.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class NewsRepoImpl : NewsRepo {

    override fun getNews(): Flow<ResultState<List<News>>> = flow {
        emit(ResultState.Loading())
        // request
        emit(ResultState.Success(emptyList()))
    }
}