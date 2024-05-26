package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.CreditCardDomain
import com.kire.market_place_android.presentation.model.CreditCard

/**
 * By Aleksey Timko (de4ltt)*/
fun CreditCardDomain.asCreditCardPresentation() = CreditCard(
    number = number,
    date = date,
    cvc = cvc
)