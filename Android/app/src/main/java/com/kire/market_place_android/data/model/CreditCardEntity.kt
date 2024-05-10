package com.kire.market_place_android.data.model

import java.util.Date

data class CreditCardEntity(
    val number: String,
    val date: Date,
    val cvc: Int
)