package com.kire.market_place_android.domain.repository

import com.kire.market_place_android.domain.model.admin.IAdminResultDomain
import com.kire.market_place_android.domain.model.user.IUserResultDomain
import com.kire.market_place_android.domain.model.user.RoleDomain

import kotlinx.coroutines.flow.Flow

/**
 * By Michael Gontarev (KiREHwYE)*/
interface IUserRepository {

    suspend fun getUserInfo(id: Int) : IUserResultDomain

    suspend fun getAllUsers(): IAdminResultDomain
    suspend fun getRole(): Flow<RoleDomain>
    suspend fun getUserId(): Flow<Int>
    suspend fun onLogout()
    suspend fun changeUserInfo(
        id: Int,
        username: String,
        phone: String,
        email: String
    ) : IUserResultDomain
    suspend fun changeUserCard(
        cardNumber: String,
        CVC: String,
        validity: String
    ) : IUserResultDomain
    suspend fun changePassword(
        currentPassword: String,
        newPassword: String,
        confirmationPassword: String
    ) : IUserResultDomain
}