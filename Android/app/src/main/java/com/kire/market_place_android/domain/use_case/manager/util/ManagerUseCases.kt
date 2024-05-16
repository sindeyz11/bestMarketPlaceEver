package com.kire.market_place_android.domain.use_case.manager.util

import com.kire.market_place_android.domain.use_case.manager.GetPickUpPointStatsUseCase
import com.kire.market_place_android.domain.use_case.manager.UpdateOrderStatusUseCase
import javax.inject.Inject

/**
 * By Aleksey Timko (de4ltt)*/
data class ManagerUseCases @Inject constructor(
    override val getPickUpPointStatsUseCase: GetPickUpPointStatsUseCase,
    override val updateOrderStatusUseCase: UpdateOrderStatusUseCase
): IManagerUseCases
