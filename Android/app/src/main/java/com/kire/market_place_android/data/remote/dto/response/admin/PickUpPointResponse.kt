package com.kire.market_place_android.data.remote.dto.response.admin

import kotlinx.serialization.Serializable

@Serializable
data class PickUpPointResponse(
    val id: Int = 0,
    val address: String = "",
    val managerName: String = "",
    val income: Double = 0.0
)
