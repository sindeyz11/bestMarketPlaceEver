package com.kire.market_place_android.domain.model.product

data class CompactProductDomain(
    val id: Int = 0,
    val title: String = "",
    val image: ImageDomain = ImageDomain(),
    val unit: String = ""
)