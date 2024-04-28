package com.kire.market_place_android.presentation.models

/**
 * By Aleksey Timko (de4ltt) 28.04.24*/
data class FilterRequest(
    val lowestPrice: Int?,
    val topPrice: Int?,
    val itemsCategory: String?
)