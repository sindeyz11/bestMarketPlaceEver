package com.kire.market_place_android.presentation.model

/**
 * By Aleksey Timko (de4ltt)*/
data class Delivery(
    val deliveryId: Int,
    val productItem: ProductItem,
    val quantity: Int,
    val deliveryStatus: DeliveryStatus,
    val deliveryCode: Int,
    val deliveryStart: String,
    val deliveryEstimate: String,
    val deliveryEnd: String?
)
