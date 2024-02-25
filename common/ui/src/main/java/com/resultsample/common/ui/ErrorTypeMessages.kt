package com.resultsample.common.ui

import com.resultsample.common.base.NoConnection
import com.resultsample.common.base.NotEnoughSpace
import com.resultsample.common.core.DataLoss
import com.resultsample.common.core.GenericError
import com.resultsample.common.core.ResultState
import com.resultsample.common.ui.ui_text.UiText
import com.resultsample.common.ui.ui_text.toUiTextOrUnknownError

val ResultState.Error.Type.uiTextError: UiText get() = when (this) {
    is GenericError -> message.toUiTextOrUnknownError()
    DataLoss -> UiText.Resource(R.string.error_data_loss)
    NoConnection -> UiText.Resource(R.string.error_no_connection)
    NotEnoughSpace -> UiText.Resource(R.string.error_not_enough_space)
    else -> UiText.Resource(R.string.error_unknown)
}