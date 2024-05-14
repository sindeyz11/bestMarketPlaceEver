package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.FilterRequestDomain
import com.kire.market_place_android.presentation.model.FilterRequest

/**
 * By Aleksey Timko (de4ltt)*/
fun FilterRequestDomain.asFilterRequestPresentation() = FilterRequest(
    lowestPrice = lowestPrice,
    topPrice = topPrice,
    itemsCategories =  itemsCategories.asSetProductCategory()
)