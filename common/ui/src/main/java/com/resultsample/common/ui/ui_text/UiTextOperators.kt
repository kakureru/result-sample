package com.resultsample.common.ui.ui_text

import com.resultsample.common.ui.R

fun String?.toUiTextOrUnknownError() = this?.let { UiText.RawString(it) } ?: UiText.Resource(R.string.error_unknown)