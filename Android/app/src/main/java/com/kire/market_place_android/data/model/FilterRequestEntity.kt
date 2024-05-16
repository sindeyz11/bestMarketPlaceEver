package com.kire.market_place_android.data.model

/**
 * By Aleksey Timko (de4ltt)*/
data class FilterRequestEntity(
    var lowestPrice: Double = 0.0,
    var topPrice: Double = 99999.9,
    var itemsCategories: Set<ProductCategoryEntity> = setOf()
)