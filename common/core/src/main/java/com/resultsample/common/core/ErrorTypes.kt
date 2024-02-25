package com.resultsample.common.core

class DataLoss : Exception()
class GenericError(override val message: String?) : Exception()