package com.resultsample.common.core

fun <T> T.success() = ResultState.Success(this)

inline fun <T> ResultState<T>.onLoading(action: () -> Unit): ResultState<T> {
    if (this is ResultState.Loading) action()
    return this
}

inline fun <T> ResultState<T>.onSuccess(action: (T) -> Unit): ResultState<T> {
    if (this is ResultState.Success) action(data)
    return this
}

inline fun <T> ResultState<T>.onError(action: (ResultState.Error.Type, data: T?) -> Unit): ResultState<T> {
    if (this is ResultState.Error) action(type, data)
    return this
}