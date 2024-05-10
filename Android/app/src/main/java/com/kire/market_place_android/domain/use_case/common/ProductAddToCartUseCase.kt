package com.kire.market_place_android.domain.use_case.common

import com.kire.market_place_android.domain.repository.IOrderRepository
import com.kire.market_place_android.domain.repository.IUserRepository
import javax.inject.Inject

class ProductAddToCartUseCase @Inject constructor(
    private val orderRepository: IOrderRepository
) {
    operator fun invoke() = { /*TODO*/ }
}