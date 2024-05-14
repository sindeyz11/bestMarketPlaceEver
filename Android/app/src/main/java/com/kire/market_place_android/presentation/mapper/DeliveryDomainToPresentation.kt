package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.DeliveryDomain
import com.kire.market_place_android.presentation.model.Delivery

/**
 * By Aleksey Timko (de4ltt)*/
fun DeliveryDomain.asDeliveryPresentation() = Delivery(
    deliveryId = deliveryId,
    productItem = productItem.asProductItemPresentation(),
    quantity = quantity,
    deliveryStatus = deliveryStatus.asDeliveryStatusPresentation(),
    deliveryCode = deliveryCode,
    deliveryStart = deliveryStart,
    deliveryEstimate = deliveryEstimate,
    deliveryEnd = deliveryEnd
)