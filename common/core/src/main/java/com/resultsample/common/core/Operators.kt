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

inline fun <T> ResultState<T>.onError(action: (Exception, data: T?) -> Unit): ResultState<T> {
    if (this is ResultState.Error) action(error, data)
    return this
}

inline fun <R, T> ResultState<T>.flatMap(transform: (value: T) -> ResultState<R>): ResultState<R> {
    return when(this) {
        is ResultState.Success -> transform(data)
        is ResultState.Error -> ResultState.Error(error, data?.let(transform)?.data)
        is ResultState.Loading -> ResultState.Loading(data?.let(transform)?.data)
    }
}