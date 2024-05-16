package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.CreditCardEntity
import com.kire.market_place_android.domain.model.CreditCardDomain

/**
 * By Michael Gontarev (KiREHwYE)*/
fun CreditCardEntity.asCreditCardDomain() = CreditCardDomain(
    number = this.number,
    date = this.date,
    cvc = this.cvc
)