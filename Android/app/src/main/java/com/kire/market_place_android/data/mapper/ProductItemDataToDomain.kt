package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.ProductItemEntity
import com.kire.market_place_android.domain.model.ProductItemDomain

fun ProductItemEntity.asProductItemDomain() = ProductItemDomain(
    itemName = this.itemName,
    itemPrice = this.itemPrice,
    itemScale = this.itemScale,
    itemDiscountPrice = this.itemDiscountPrice,
    imageUri = this.imageUri,
    isFavourite = this.isFavourite,
    itemDescription = this.itemDescription
)