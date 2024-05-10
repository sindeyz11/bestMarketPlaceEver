package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.PickUpPointDomain
import com.kire.market_place_android.presentation.model.PickUpPoint

fun PickUpPoint.asPickUpPointDomain() = PickUpPointDomain(
    id, adress, manager.asUserPresenationToDomain(), income
)