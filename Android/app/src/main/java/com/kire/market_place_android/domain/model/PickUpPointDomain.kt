package com.kire.market_place_android.domain.model

data class PickUpPointDomain(
    val id: Int,
    val adress: String,
    val manager: UserDomain,
    val income: Double
)