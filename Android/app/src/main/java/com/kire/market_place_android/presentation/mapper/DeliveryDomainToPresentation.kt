package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.DeliveryDomain
import com.kire.market_place_android.presentation.model.Delivery

fun DeliveryDomain.asDeliveryPresentation() = Delivery(
    deliveryId,
    productItem.asProductItemPresentation(),
    quantity,
    deliveryStatus.asDeliveryStatusPresentation(),
    deliveryCode,
    deliveryStart,
    deliveryEstimate,
    deliveryEnd
)