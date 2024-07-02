package com.kire.market_place_android.presentation.mapper.product

import com.kire.market_place_android.domain.model.product.CategoryDomain
import com.kire.market_place_android.presentation.model.product.Category

fun CategoryDomain.toPresentation() = Category(
    name = this.name,
    count = this.count
)