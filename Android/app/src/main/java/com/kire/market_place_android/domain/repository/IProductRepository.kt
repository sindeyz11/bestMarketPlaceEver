package com.kire.market_place_android.domain.repository

import com.kire.market_place_android.domain.model.product.IProductResultDomain

/**
 * By Michael Gontarev (KiREHwYE)*/
interface IProductRepository {

    suspend fun getAllProducts(): IProductResultDomain
    suspend fun getAllAvailableCategories():  IProductResultDomain

}