package com.kire.market_place_android.presentation.mapper.product

import com.kire.market_place_android.domain.model.product.ProductDomain
import com.kire.market_place_android.presentation.mapper.order.toDomain
import com.kire.market_place_android.presentation.model.product.Product

fun Product.toDomain() = ProductDomain(
    id = id,
    title = title,
    image = image.toDomain(),
    description = description,
    price = price,
    discountPrice = discountPrice,
    quantityAvailable = quantityAvailable,
    unit = unit,
    deliveryDays = deliveryDays,
    category = category
)