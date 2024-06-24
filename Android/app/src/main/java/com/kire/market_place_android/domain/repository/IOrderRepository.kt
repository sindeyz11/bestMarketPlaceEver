package com.kire.market_place_android.domain.repository

import com.kire.market_place_android.domain.model.order.IOrderResultDomain

/**
 * By Michael Gontarev (KiREHwYE)*/
interface IOrderRepository {

    suspend fun getOrdersByUser(): IOrderResultDomain
}