package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.ProductItemDomain
import com.kire.market_place_android.presentation.model.ProductItem

/**
 * By Aleksey Timko (de4ltt)*/
fun ProductItemDomain.asProductItemPresentation() = ProductItem(
    itemName = itemName,
    itemPrice = itemPrice,
    itemScale = itemScale,
    itemDiscountPrice = itemDiscountPrice,
    imageUri = imageUri,
    isFavourite = isFavourite,
    itemDescription = itemDescription
)