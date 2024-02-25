package com.resultsample.common.ui

import com.resultsample.common.base.NoConnection
import com.resultsample.common.base.NotEnoughSpace
import com.resultsample.common.core.DataLoss
import com.resultsample.common.core.GenericError
import com.resultsample.common.core.ResultState

val Throwable.uiTextError: UiText get() = when (this) {
    is GenericError -> message?.let { UiText.RawString(it) } ?: UiText.Resource(R.string.error_unknown)
    is DataLoss -> UiText.Resource(R.string.error_data_loss)
    is NoConnection -> UiText.Resource(R.string.error_no_connection)
    is NotEnoughSpace -> UiText.Resource(R.string.error_not_enough_space)
    else -> UiText.Resource(R.string.error_unknown)
}