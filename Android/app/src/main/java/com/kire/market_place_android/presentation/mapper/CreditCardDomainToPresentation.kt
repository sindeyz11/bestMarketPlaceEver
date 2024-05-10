package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.CreditCardDomain
import com.kire.market_place_android.presentation.model.CreditCard

fun CreditCardDomain.asCreditCardPresentation() = CreditCard(
    number, date, cvc
)