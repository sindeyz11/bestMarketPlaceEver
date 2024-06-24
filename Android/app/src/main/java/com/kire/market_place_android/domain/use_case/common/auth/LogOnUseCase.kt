package com.kire.market_place_android.domain.use_case.common.auth

import com.kire.market_place_android.domain.model.auth.AuthResultDomain
import com.kire.market_place_android.domain.repository.IAuthRepository

import javax.inject.Inject

/**
 * By Michael Gontarev (KiREHwYE)*/
class LogOnUseCase @Inject constructor(
    private val authRepository: IAuthRepository
) {
    suspend operator fun invoke(
        name: String,
        phone: String,
        email: String,
        password: String
    ) : AuthResultDomain<String> {
        return authRepository.logOn(
            name = name,
            phone = phone,
            email = email,
            password = password
        )
    }
}