package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.ProductCategoryDomain
import com.kire.market_place_android.presentation.model.ProductCategory

/**
 * By Aleksey Timko (de4ltt)*/
fun ProductCategoryDomain.asProductCategoryPresentation() = ProductCategory.valueOf(this.categoryName)

/**
 * By Aleksey Timko (de4ltt)*/
fun Set<ProductCategoryDomain>.asSetProductCategory() =
    this.map { it.asProductCategoryPresentation() }.toSet()