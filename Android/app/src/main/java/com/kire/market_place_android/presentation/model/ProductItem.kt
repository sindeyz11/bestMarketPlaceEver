package com.kire.market_place_android.presentation.model

import android.net.Uri

/**
 * By Aleksey Timko (de4ltt)*/
data class ProductItem(
    val itemName: String,
    val itemPrice: String,
    val itemScale: String,
    val itemDiscountPrice: String,
    val imageUri: Uri?,
    val isFavourite: Boolean,
    val itemDescription: String
)