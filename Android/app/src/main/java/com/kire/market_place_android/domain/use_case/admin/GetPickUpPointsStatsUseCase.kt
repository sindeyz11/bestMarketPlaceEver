package com.kire.market_place_android.domain.use_case.admin

import com.kire.market_place_android.domain.repository.IPickUpPointRepository

import javax.inject.Inject

/**
 * By Aleksey Timko (de4ltt)*/
class GetPickUpPointsStatsUseCase @Inject constructor(
    private val pickUpPointRepository: IPickUpPointRepository
) {
    operator fun invoke() {
        /*TODO*/
    }
}