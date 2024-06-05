package com.kire.market_place_android.data.model

import java.util.Date

/**
 * By Aleksey Timko (de4ltt)*/
data class CreditCardEntity(
    val number: String,
    val date: Date,
    val cvc: Int
)