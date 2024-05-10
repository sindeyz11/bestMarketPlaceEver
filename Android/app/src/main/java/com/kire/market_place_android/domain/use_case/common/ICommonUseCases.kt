package com.kire.market_place_android.domain.use_case.common

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