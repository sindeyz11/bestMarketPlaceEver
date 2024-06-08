package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.FilterRequestEntity
import com.kire.market_place_android.domain.model.FilterRequestDomain
import com.kire.market_place_android.presentation.model.FilterRequest

/**
 * By Michael Gontarev (KiREHwYE)*/
fun FilterRequestEntity.asFilterRequestDomain() = FilterRequestDomain(
    lowestPrice = this.lowestPrice,
    topPrice = this.topPrice,
    itemsCategories = this.itemsCategories.asSetProductCategoryDomain()
)