package com.kire.market_place_android.presentation.model.product


data class CompactProduct(
    val id: Int = 0,
    val title: String = "",
    val image: Image = Image(),
    val unit: String = ""
)
