package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.CreditCardEntity
import com.kire.market_place_android.domain.model.CreditCardDomain

fun CreditCardEntity.asCreditCardDomain() = CreditCardDomain(
    number = this.number,
    date = this.date,
    cvc = this.cvc
)