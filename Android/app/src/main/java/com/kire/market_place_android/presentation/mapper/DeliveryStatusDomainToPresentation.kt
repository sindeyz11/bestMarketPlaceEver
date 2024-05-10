package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.DeliveryStatusDomain
import com.kire.market_place_android.presentation.model.DeliveryStatus

fun DeliveryStatusDomain.asDeliveryStatusPresentation() =
    DeliveryStatus.valueOf(this.status)