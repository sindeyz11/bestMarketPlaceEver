package com.kire.market_place_android.presentation.model.order

sealed interface IOrderResult {
    class Success(val data: List<Order>): IOrderResult
    object Idle: IOrderResult
    class Error(val message: String?): IOrderResult
}