package com.kire.market_place_android.domain.repository

import com.kire.market_place_android.domain.model.auth.AuthResultDomain

/**
 * By Michael Gontarev (KiREHwYE)*/
interface ILogOnRepository {

    suspend fun logOn(
        name: String,
        phone: String,
        email: String,
        password: String
    ) : AuthResultDomain<String>
}