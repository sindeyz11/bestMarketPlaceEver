package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.DeliveryStatusEntity
import com.kire.market_place_android.domain.model.DeliveryStatusDomain


fun DeliveryStatusEntity.asDeliveryStatusDomain() =
    DeliveryStatusDomain.valueOf(this.status)