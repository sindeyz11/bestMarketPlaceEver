package com.kire.market_place_android.domain.repository

import com.kire.market_place_android.domain.model.auth.AuthResultDomain

import kotlinx.coroutines.flow.Flow

interface IAuthRepository {

    suspend fun logIn(phone: String, password: String): AuthResultDomain<String>

    suspend fun isTokenExpired(): Boolean

    suspend fun logOn(
        name: String,
        phone: String,
        email: String,
        password: String
    ): AuthResultDomain<String>

    suspend fun isAuthenticated(): Flow<Boolean>

    suspend fun onLogOut()
}