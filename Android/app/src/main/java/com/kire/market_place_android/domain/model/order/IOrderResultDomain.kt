package com.kire.market_place_android.domain.model.order

sealed interface IOrderResultDomain {
    class Success<T>(val data: T): IOrderResultDomain
    object SuccessfullyDone: IOrderResultDomain
    class Error(val message: String?): IOrderResultDomain
    object Idle: IOrderResultDomain
}