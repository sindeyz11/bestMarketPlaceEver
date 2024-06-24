package com.kire.market_place_android.presentation.model.product

sealed interface IProductResult {
    class Success<T>(val data: List<T>): IProductResult
    object SuccessfullyDone: IProductResult
    object Idle: IProductResult
    class Error(val message: String?): IProductResult
}