package com.kire.market_place_android.domain.use_case.admin.util

import com.kire.market_place_android.domain.use_case.admin.DeletePickUpPointUseCase
import com.kire.market_place_android.domain.use_case.admin.DeleteProductUseCase
import com.kire.market_place_android.domain.use_case.admin.GetPickUpPointsStatsUseCase
import com.kire.market_place_android.domain.use_case.admin.GetUsersStatsUseCase
import com.kire.market_place_android.domain.use_case.admin.UpdatePickUpPointUseCase
import com.kire.market_place_android.domain.use_case.admin.UpdateProductUseCase

/**
 * By Michael Gontarev (KiREHwYE)*/
sealed interface IAdminUseCases {
    val deletePickUpPointUseCase: DeletePickUpPointUseCase
    val deleteProductUseCase: DeleteProductUseCase
    val getPickUpPointUseCase: GetPickUpPointsStatsUseCase
    val getUsersStatusUseCase: GetUsersStatsUseCase
    val updateProductUseCase: UpdateProductUseCase
    val updatePickUpPointUseCase: UpdatePickUpPointUseCase
}