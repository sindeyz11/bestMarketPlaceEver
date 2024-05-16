package com.kire.market_place_android.domain.use_case.manager.util

import com.kire.market_place_android.domain.use_case.manager.GetPickUpPointStatsUseCase
import com.kire.market_place_android.domain.use_case.manager.UpdateOrderStatusUseCase

/**
 * By Aleksey Timko (de4ltt)*/
sealed interface IManagerUseCases {
    val getPickUpPointStatsUseCase: GetPickUpPointStatsUseCase
    val updateOrderStatusUseCase: UpdateOrderStatusUseCase
}