package com.kire.market_place_android.domain.model

/**
 * By Aleksey Timko (de4ltt)*/
data class FilterRequestDomain(
    var lowestPrice: Double = 0.0,
    var topPrice: Double = 99999.9,
    var itemsCategories: Set<ProductCategoryDomain> = setOf()
)