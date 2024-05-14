package com.kire.market_place_android.domain.use_case.common.util

import com.kire.market_place_android.domain.use_case.common.EditUserAccountInfoUseCase
import com.kire.market_place_android.domain.use_case.common.GetDeliveriesStatusUseCase
import com.kire.market_place_android.domain.use_case.common.GetPersonalStatisticsUseCase
import com.kire.market_place_android.domain.use_case.common.GetProductListUseCase
import com.kire.market_place_android.domain.use_case.common.LoginUseCase
import com.kire.market_place_android.domain.use_case.common.OrderUseCase
import com.kire.market_place_android.domain.use_case.common.ProductAddToCartUseCase
import com.kire.market_place_android.domain.use_case.common.ProductDeleteFromCartUseCase
import com.kire.market_place_android.domain.use_case.common.RegisterUseCase

/**
 * By Aleksey Timko (de4ltt)*/
sealed interface ICommonUseCases {
    val editUserAccountInfoUseCase: EditUserAccountInfoUseCase
    val getDeliveriesStatusUseCase: GetDeliveriesStatusUseCase
    val getPersonalStatisticsUseCase: GetPersonalStatisticsUseCase
    val loginUseCase: LoginUseCase
    val orderUseCase: OrderUseCase
    val productAddToCartUseCase: ProductAddToCartUseCase
    val productDeleteFromCartUseCase: ProductDeleteFromCartUseCase
    val registerUseCase: RegisterUseCase
    val getProductListUseCase: GetProductListUseCase
}