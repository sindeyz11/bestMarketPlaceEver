package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.DeliveryStatusDomain
import com.kire.market_place_android.presentation.model.DeliveryStatus

fun DeliveryStatus.asDeliveryStatusDomain() =
    DeliveryStatusDomain.valueOf(this.status)