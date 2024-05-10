package com.kire.market_place_android.domain.use_case.manager

/**
 * By Aleksey Timko (de4ltt)*/
sealed interface IManagerUseCases {
    val getPickUpPointStatsUseCase: GetPickUpPointStatsUseCase
    val updateOrderStatusUseCase: UpdateOrderStatusUseCase
}