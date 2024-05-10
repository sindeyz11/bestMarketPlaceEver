package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.FilterRequestDomain
import com.kire.market_place_android.presentation.model.FilterRequest

fun FilterRequestDomain.asFilterRequestPresentation() = FilterRequest(
    lowestPrice, topPrice, itemsCategories.asSetProductCategory()
)