package com.kire.market_place_android.presentation.model

import java.util.Date

/**
 * By Michael Gontarev (KiREHwYE)*/
data class ProfileScreenUserData(
    val name: String,
    val phone: String,
    val email: String,
    val totalPurchases: Double = 0.0,
    val totalPurchasesPercent: Double = 0.0,
    val discount: Double = 0.0,
    val nextDeliveryDate: Date? = null,
    val creditCard: CreditCard? = null
)
