package com.kire.market_place_android.presentation.mapper.order

import com.kire.market_place_android.domain.model.order.OrderDomain
import com.kire.market_place_android.presentation.model.order.Order

fun OrderDomain.toDomain() = Order(
    orderId = this.orderId,
    products = this.products.toDomain(),
    datetime = this.datetime,
    completed = this.completed
)