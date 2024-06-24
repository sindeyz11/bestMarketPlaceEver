package com.kire.market_place_android.presentation.mapper.order

import com.kire.market_place_android.domain.model.order.IOrderResultDomain
import com.kire.market_place_android.presentation.model.order.IOrderResult

fun IOrderResultDomain.toDomain() =
    when(this) {
        is IOrderResultDomain.Success -> {
            IOrderResult.Success(this.data.toDomain())
        }
        IOrderResultDomain.Idle -> {
            IOrderResult.Idle
        }
        is IOrderResultDomain.Error -> {
            IOrderResult.Error(this.message)
        }
    }