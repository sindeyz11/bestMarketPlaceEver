package com.kire.market_place_android.presentation.model

sealed interface IRequestResult {
    class Success<T>(val data: T): IRequestResult
    object SuccessfullyDone: IRequestResult
    class Error(val message: String?): IRequestResult
    object Idle: IRequestResult
}