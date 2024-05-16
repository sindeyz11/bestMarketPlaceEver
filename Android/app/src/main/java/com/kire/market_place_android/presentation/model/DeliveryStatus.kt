package com.kire.market_place_android.presentation.model

/**
 * By Aleksey Timko (de4ltt)*/
enum class DeliveryStatus(
    val status: String
) {

    DENIED("denied"),
    READY("ready"),
    ON_THE_WAY("on the way"),
    DELIVERED("delivered")
}