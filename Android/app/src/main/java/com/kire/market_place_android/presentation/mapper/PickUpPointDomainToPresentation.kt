package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.PickUpPointDomain
import com.kire.market_place_android.presentation.model.PickUpPoint

/**
 * By Aleksey Timko (de4ltt)*/
fun PickUpPointDomain.asPickUpPointPresentation() = PickUpPoint(
    id = id,
    adress = adress,
    manager = manager.asUserPresentation(),
    income = income
)