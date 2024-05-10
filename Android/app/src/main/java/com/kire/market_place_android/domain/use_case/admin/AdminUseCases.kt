package com.kire.market_place_android.domain.use_case.admin

import javax.inject.Inject

/**
 * By Michael Gontarev (KiREHwYE)*/
data class AdminUseCases @Inject constructor(
    override val deletePickUpPointUseCase: DeletePickUpPointUseCase,
    override val deleteProductUseCase: DeleteProductUseCase,
    override val getPickUpPointUseCase: GetPickUpPointsStatsUseCase,
    override val getUsersStatusUseCase: GetUsersStatsUseCase,
    override val updatePickUpPointUseCase: UpdatePickUpPointUseCase,
    override val updateProductUseCase: UpdateProductUseCase
): IAdminUseCases