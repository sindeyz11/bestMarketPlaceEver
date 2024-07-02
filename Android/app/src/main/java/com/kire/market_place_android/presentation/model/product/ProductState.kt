package com.kire.market_place_android.presentation.model.product

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class ProductState(
    var itemName: String = "",
    var itemCategory: String = "",
    var itemPrice: String = "",
    var itemDiscountPrice: String = "",
    var itemMeasure: String = "",
    var itemStored: String = "",
    var itemDescription: String = ""
)