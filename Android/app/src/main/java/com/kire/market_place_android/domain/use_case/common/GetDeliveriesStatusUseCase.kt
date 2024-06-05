package com.kire.market_place_android.domain.use_case.common

import com.kire.market_place_android.domain.repository.IUserRepository
import javax.inject.Inject

/**
 * By Aleksey Timko (de4ltt)*/
class GetDeliveriesStatusUseCase @Inject constructor(
    private val userRepository: IUserRepository
) {

    operator fun invoke() {

    }
}
