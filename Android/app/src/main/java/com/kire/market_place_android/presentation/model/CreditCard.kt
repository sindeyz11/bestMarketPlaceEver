package com.kire.market_place_android.presentation.model

import java.util.Date

/**
 * By Michael Gontarev (KiREHwYE))*/
data class CreditCard(
    val number: String,
    val date: Date,
    val cvc: Int
)