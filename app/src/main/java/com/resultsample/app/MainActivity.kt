package com.resultsample.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.resultsample.common.core.onError
import com.resultsample.common.core.onLoading
import com.resultsample.common.core.onSuccess
import com.resultsample.component.news.data.NewsRepoImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}