package com.kire.market_place_android.domain.repository

import com.kire.market_place_android.domain.model.admin.IAdminResultDomain

/**
 * By Michael Gontarev (KiREHwYE)*/
interface IPickUpPointRepository {
    suspend fun getAllPickUpPoints(): IAdminResultDomain
    suspend fun createPickUpPoint(managerId: Int, address: String): IAdminResultDomain
    suspend fun updatePickUpPoint(id: Int, managerId: Int, address: String): IAdminResultDomain
    suspend fun deletePickUpPoint(id: Int): IAdminResultDomain
}