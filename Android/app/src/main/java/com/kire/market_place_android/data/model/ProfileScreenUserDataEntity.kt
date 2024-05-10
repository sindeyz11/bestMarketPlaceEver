package com.kire.market_place_android.data.model

import java.util.Date

data class ProfileScreenUserDataEntity(
    val name: String,
    val phone: String,
    val email: String,
    val totalPurchases: Double = 0.0,
    val totalPurchasesPercent: Double = 0.0,
    val discount: Double = 0.0,
    val nextDeliveryDate: Date? = null,
    val creditCard: CreditCardEntity? = null
)
