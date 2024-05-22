package com.kire.market_place_android.domain.model

/**
 * By Aleksey Timko (de4ltt)*/
data class DeliveryDomain(
    val deliveryId: Int,
    val productItem: ProductItemDomain,
    val quantity: Int,
    val deliveryStatus: DeliveryStatusDomain,
    val deliveryCode: Int,
    val deliveryStart: String,
    val deliveryEstimate: String,
    val deliveryEnd: String?
)
