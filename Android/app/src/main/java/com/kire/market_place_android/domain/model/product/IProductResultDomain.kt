package com.kire.market_place_android.domain.model.product

sealed interface IProductResultDomain {
    class Success<T>(val data: List<T>): IProductResultDomain
    object SuccessfullyDone: IProductResultDomain
    object Idle: IProductResultDomain
    class Error(val message: String?): IProductResultDomain
}