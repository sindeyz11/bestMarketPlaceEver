package com.kire.market_place_android.domain.repository

import com.kire.market_place_android.domain.model.IRequestResultDomain

/**
 * By Michael Gontarev (KiREHwYE)*/
interface IProductRepository {

    suspend fun getAllProducts(): IRequestResultDomain
    suspend fun getAllAvailableCategories():  IRequestResultDomain

}