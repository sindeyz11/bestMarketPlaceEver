package com.kire.market_place_android.domain.model

import java.util.Date

data class CreditCardDomain(
    val number: String,
    val date: Date,
    val cvc: Int
)