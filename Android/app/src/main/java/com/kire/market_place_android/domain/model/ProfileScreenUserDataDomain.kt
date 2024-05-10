package com.kire.market_place_android.domain.model

import java.util.Date

data class ProfileScreenUserDataDomain(
    val name: String,
    val phone: String,
    val email: String,
    val totalPurchases: Double = 0.0,
    val totalPurchasesPercent: Double = 0.0,
    val discount: Double = 0.0,
    val nextDeliveryDate: Date? = null,
    val creditCard: CreditCardDomain? = null
)
