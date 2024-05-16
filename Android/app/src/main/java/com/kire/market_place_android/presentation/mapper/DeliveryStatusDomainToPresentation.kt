package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.DeliveryStatusDomain
import com.kire.market_place_android.presentation.model.DeliveryStatus

/**
 * By Aleksey Timko (de4ltt)*/
fun DeliveryStatusDomain.asDeliveryStatusPresentation() =
    DeliveryStatus.valueOf(this.status)