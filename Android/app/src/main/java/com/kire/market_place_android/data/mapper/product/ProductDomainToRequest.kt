package com.kire.market_place_android.data.mapper.product

import com.kire.market_place_android.data.remote.dto.request.product.ProductRequest
import com.kire.market_place_android.domain.model.product.ProductDomain

fun ProductDomain.toRequest(image: Array<Byte>) = ProductRequest(
    title = title,
    image = image,
    alt = this.image.alt,
    description = description,
    price = price,
    discountPrice = discountPrice,
    quantityOfAvailable = quantityAvailable,
    unit = unit,
    deliveryDays = deliveryDays,
    categoryId = 0
)