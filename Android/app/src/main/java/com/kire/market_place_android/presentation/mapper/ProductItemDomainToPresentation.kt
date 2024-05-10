package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.ProductItemDomain
import com.kire.market_place_android.presentation.model.ProductItem

fun ProductItemDomain.asProductItemPresentation() = ProductItem(
    itemName, itemPrice, itemScale, itemDiscountPrice, imageUri, isFavourite, itemDescription
)