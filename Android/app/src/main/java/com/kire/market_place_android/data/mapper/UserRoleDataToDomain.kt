package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.UserRoleEntity
import com.kire.market_place_android.domain.model.UserRoleDomain

/**
 * By Michael Gontarev (KiREHwYE)*/
fun UserRoleEntity.asUserRoleDomain() =
    UserRoleDomain.valueOf(this.name)