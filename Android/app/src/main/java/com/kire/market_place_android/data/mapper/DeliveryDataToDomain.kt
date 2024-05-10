package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.DeliveryEntity
import com.kire.market_place_android.domain.model.DeliveryDomain

fun DeliveryEntity.asDeliveryDomain() = DeliveryDomain(
    deliveryId = this.deliveryId,
    productItem = this.productItem.asProductItemDomain(),
    quantity = this.quantity,
    deliveryStatus = this.deliveryStatus.asDeliveryStatusDomain(),
    deliveryCode = this.deliveryCode,
    deliveryStart = this.deliveryStart,
    deliveryEstimate = this.deliveryEstimate,
    deliveryEnd = this.deliveryEnd
)