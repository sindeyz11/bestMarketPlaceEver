package com.kire.market_place_android.presentation.mapper.order

import com.kire.market_place_android.domain.model.order.OrderedProductDomain

fun List<OrderedProductDomain>.toDomain() = this.map { orderedProductDomain ->
    orderedProductDomain.toDomain()
}