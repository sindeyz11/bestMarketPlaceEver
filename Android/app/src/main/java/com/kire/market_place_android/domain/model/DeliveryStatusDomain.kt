package com.kire.market_place_android.domain.model

enum class DeliveryStatusDomain(
    val status: String
) {

    DENIED("denied"),
    READY("ready"),
    ON_THE_WAY("on the way"),
    DELIVERED("delivered")
}