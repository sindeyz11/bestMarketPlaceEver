package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.ProductCategoryDomain
import com.kire.market_place_android.presentation.model.ProductCategory

fun ProductCategoryDomain.asProductCategoryPresentation() = ProductCategory.valueOf(this.categoryName)

fun Set<ProductCategoryDomain>.asSetProductCategory() =
    this.map { it.asProductCategoryPresentation() }.toSet()