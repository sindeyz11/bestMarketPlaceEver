package com.kire.market_place_android.domain.use_case.manager

import javax.inject.Inject

data class ManagerUseCases @Inject constructor(
    override val getPickUpPointStatsUseCase: GetPickUpPointStatsUseCase,
    override val updateOrderStatusUseCase: UpdateOrderStatusUseCase
): IManagerUseCases
