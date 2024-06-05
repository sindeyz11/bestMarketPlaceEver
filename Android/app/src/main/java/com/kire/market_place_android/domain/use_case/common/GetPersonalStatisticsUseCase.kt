package com.kire.market_place_android.domain.use_case.common

import com.kire.market_place_android.domain.repository.IUserRepository
import javax.inject.Inject

/**
 * By Michael Gontarev (KiREHwYE)*/
class GetPersonalStatisticsUseCase @Inject constructor(
    private val userRepository: IUserRepository
) {

    suspend operator fun invoke() {
        /*TODO()*/
    }

}