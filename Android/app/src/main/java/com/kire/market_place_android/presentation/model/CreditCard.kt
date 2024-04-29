package com.kire.market_place_android.presentation.model

import java.util.Date

data class CreditCard(
    val number: String,
    val date: Date,
    val cvc: Int
)