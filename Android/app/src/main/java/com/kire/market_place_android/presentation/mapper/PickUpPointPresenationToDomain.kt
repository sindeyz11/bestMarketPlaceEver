package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.PickUpPointDomain
import com.kire.market_place_android.presentation.model.PickUpPoint

/**
 * By Aleksey Timko (de4ltt)*/
fun PickUpPoint.asPickUpPointDomain() = PickUpPointDomain(
    id = id,
    adress = adress,
    manager = manager.asUserPresentationToDomain(),
    income = income
)