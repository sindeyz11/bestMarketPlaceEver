package com.kire.market_place_android.domain.use_case.common

import javax.inject.Inject

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
