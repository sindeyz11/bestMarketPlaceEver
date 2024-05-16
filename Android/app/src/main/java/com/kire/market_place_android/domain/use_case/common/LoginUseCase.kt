package com.kire.market_place_android.domain.use_case.common

import com.kire.market_place_android.domain.repository.ILoginRepository
import javax.inject.Inject

/**
 * By Michael Gontarev (KiREHwYE)*/
class LoginUseCase @Inject constructor(
    private val loginRepository: ILoginRepository
) {

    suspend operator fun invoke() {
        /*TODO()*/
    }
}