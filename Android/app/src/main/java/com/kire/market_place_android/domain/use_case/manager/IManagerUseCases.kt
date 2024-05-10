package com.kire.market_place_android.domain.use_case.manager

sealed interface IManagerUseCases {
    val getPickUpPointStatsUseCase: GetPickUpPointStatsUseCase
    val updateOrderStatusUseCase: UpdateOrderStatusUseCase
}