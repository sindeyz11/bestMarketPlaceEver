package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.FilterRequestDomain
import com.kire.market_place_android.domain.model.ProductCategoryDomain
import com.kire.market_place_android.presentation.model.FilterRequest
import com.kire.market_place_android.presentation.model.ProductCategory

fun FilterRequest.asFilterRequestDomain() = FilterRequestDomain(
    lowestPrice, topPrice, itemsCategories.asSetProductCategoryDomain()
)