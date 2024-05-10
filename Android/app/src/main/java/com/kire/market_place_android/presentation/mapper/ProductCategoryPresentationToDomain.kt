package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.ProductCategoryDomain
import com.kire.market_place_android.presentation.model.ProductCategory

fun ProductCategory.asProductCategoryDomain() = ProductCategoryDomain.valueOf(this.categoryName)

fun Set<ProductCategory>.asSetProductCategoryDomain() =
    this.map { it.asProductCategoryDomain() }.toSet()