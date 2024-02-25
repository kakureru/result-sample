package com.resultsample.features.news

import androidx.lifecycle.ViewModel
import com.resultsample.common.core.DataLoss
import com.resultsample.common.core.ResultState
import com.resultsample.common.core.onError
import com.resultsample.common.core.onLoading
import com.resultsample.common.core.onSuccess
import com.resultsample.common.ui.uiTextError
import com.resultsample.common.ui.UiText
import com.resultsample.component.news.model.NewsProhibited
import com.resultsample.component.news.NewsRepo
import com.resultsample.component.news.model.SomethingElse
import kotlinx.coroutines.flow.collectLatest
import java.io.IOException

class NewsViewModel(
    private val newsRepo: NewsRepo,
) : ViewModel() {

    private suspend fun loadNews() {
        newsRepo.getNews().collectLatest { result ->
            result.onLoading {
                // show loader
            }.onSuccess {
                // show data
            }.onError { error, data ->
                val message = when (error) {
                    is NewsProhibited -> UiText.Resource(R.string.error_news_prohibitet)
                    is SomethingElse -> UiText.Resource(R.string.error_something_else)
                    else -> error.uiTextError
                }
                // show message or ui state
            }
        }
    }
}