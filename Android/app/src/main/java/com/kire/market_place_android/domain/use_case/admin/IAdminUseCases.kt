package com.kire.market_place_android.domain.use_case.admin

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