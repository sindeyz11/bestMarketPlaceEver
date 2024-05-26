package com.kire.market_place_android.domain.use_case.admin.util

import com.kire.market_place_android.domain.use_case.admin.DeletePickUpPointUseCase
import com.kire.market_place_android.domain.use_case.admin.DeleteProductUseCase
import com.kire.market_place_android.domain.use_case.admin.GetPickUpPointsStatsUseCase
import com.kire.market_place_android.domain.use_case.admin.GetUsersStatsUseCase
import com.kire.market_place_android.domain.use_case.admin.UpdatePickUpPointUseCase
import com.kire.market_place_android.domain.use_case.admin.UpdateProductUseCase
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