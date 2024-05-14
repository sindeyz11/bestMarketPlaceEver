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
import javax.inject.Inject

/**
 * By Aleksey Timko (de4ltt)*/
data class CommonUseCases @Inject constructor(
    override val editUserAccountInfoUseCase: EditUserAccountInfoUseCase,
    override val getDeliveriesStatusUseCase: GetDeliveriesStatusUseCase,
    override val getPersonalStatisticsUseCase: GetPersonalStatisticsUseCase,
    override val loginUseCase: LoginUseCase,
    override val orderUseCase: OrderUseCase,
    override val productAddToCartUseCase: ProductAddToCartUseCase,
    override val productDeleteFromCartUseCase: ProductDeleteFromCartUseCase,
    override val registerUseCase: RegisterUseCase,
    override val getProductListUseCase: GetProductListUseCase
) : ICommonUseCases
