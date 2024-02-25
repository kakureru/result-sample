package com.resultsample.common.core

data object DataLoss : ResultState.Error.Type
class GenericError(val message: String?) : ResultState.Error.Type