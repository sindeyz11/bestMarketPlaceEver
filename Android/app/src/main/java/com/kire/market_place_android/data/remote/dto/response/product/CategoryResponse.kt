package com.kire.market_place_android.data.remote.dto.response.product

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val name: String = "",
    val count: Int = 0
)
