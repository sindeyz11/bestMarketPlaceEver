package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.DeliveryDomain
import com.kire.market_place_android.presentation.model.Delivery

/**
 * By Aleksey Timko (de4ltt)*/
fun Delivery.asDeliveryDomain() = DeliveryDomain(
    deliveryId = deliveryId,
    productItem = productItem.asProductItemDomain(),
    quantity = quantity,
    deliveryStatus = deliveryStatus.asDeliveryStatusDomain(),
    deliveryCode = deliveryCode,
    deliveryStart = deliveryStart,
    deliveryEstimate = deliveryEstimate,
    deliveryEnd = deliveryEnd
)