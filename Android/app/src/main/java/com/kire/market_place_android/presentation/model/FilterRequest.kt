package com.kire.market_place_android.presentation.model

/**
 * By Aleksey Timko (de4ltt)*/
data class FilterRequest(
    var lowestPrice: Double = 0.0,
    var topPrice: Double = 99999.9,
    var itemsCategories: Set<ProductCategory> = setOf()
)