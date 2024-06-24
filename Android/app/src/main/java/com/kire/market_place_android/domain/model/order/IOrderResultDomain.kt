package com.kire.market_place_android.domain.model.order

sealed interface IOrderResultDomain {
    class Success(val data: List<OrderDomain>): IOrderResultDomain
    object Idle: IOrderResultDomain
    class Error(val message: String?): IOrderResultDomain
}