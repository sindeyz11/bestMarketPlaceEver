package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.PickUpPointEntity
import com.kire.market_place_android.domain.model.PickUpPointDomain

/**
 * By Michael Gontarev (KiREHwYE)*/
fun PickUpPointEntity.asPickUpPointDomain() = PickUpPointDomain(
    id = this.id,
    adress = this.adress,
    manager = this.manager.asUserDomain(),
    income = this.income
)