package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.ProductItemDomain
import com.kire.market_place_android.presentation.model.ProductItem

fun ProductItem.asProductItemDomain() = ProductItemDomain(
    itemName, itemPrice, itemScale, itemDiscountPrice, imageUri, isFavourite, itemDescription
)