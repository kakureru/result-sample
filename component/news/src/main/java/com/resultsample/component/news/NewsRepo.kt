package com.resultsample.component.news

import com.resultsample.common.core.ResultState
import com.resultsample.component.news.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepo {
    fun getNews(): Flow<ResultState<List<News>>>
}