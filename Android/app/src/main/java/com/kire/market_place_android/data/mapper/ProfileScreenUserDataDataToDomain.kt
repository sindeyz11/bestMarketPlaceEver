package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.ProfileScreenUserDataEntity
import com.kire.market_place_android.domain.model.ProfileScreenUserDataDomain

fun ProfileScreenUserDataEntity.asProfileScreenUserDataDomain() = ProfileScreenUserDataDomain(
    name = this.name,
    email = this.email,
    phone = this.phone,
    totalPurchases = this.totalPurchases,
    totalPurchasesPercent = this.totalPurchasesPercent,
    discount = this.discount,
    nextDeliveryDate = this.nextDeliveryDate,
    creditCard = this.creditCard?.asCreditCardDomain()
)