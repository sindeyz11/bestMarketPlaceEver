package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.ProductCategoryEntity

fun Set<ProductCategoryEntity>.asSetProductCategoryDomain() =
    this.map { it.asProductCategoryDomain() }.toSet()