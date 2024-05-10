package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.UserEntity
import com.kire.market_place_android.domain.model.UserDomain

fun UserEntity.asUserDomain() = UserDomain(
    userId = this.userId,
    userName = this.userName,
    userRole = this.userRole.asUserRoleDomain(),
    userSpent = this.userSpent,
    userDiscount = this.userDiscount
)