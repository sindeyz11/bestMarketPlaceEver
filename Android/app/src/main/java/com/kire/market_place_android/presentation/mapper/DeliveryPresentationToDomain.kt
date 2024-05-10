package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.DeliveryDomain
import com.kire.market_place_android.presentation.model.Delivery

fun Delivery.asDeliveryDomain() = DeliveryDomain(
    deliveryId,
    productItem.asProductItemDomain(),
    quantity,
    deliveryStatus.asDeliveryStatusDomain(),
    deliveryCode,
    deliveryStart,
    deliveryEstimate,
    deliveryEnd
)