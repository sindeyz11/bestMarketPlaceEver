package com.kire.market_place_android.domain.use_case.common

import com.kire.market_place_android.domain.repository.IRegistrationRepository
import javax.inject.Inject

/**
 * By Michael Gontarev (KiREHwYE)*/
class RegisterUseCase @Inject constructor(
    private val registrationRepository: IRegistrationRepository
) {

    suspend operator fun invoke() {
        /*TODO()*/
    }
}