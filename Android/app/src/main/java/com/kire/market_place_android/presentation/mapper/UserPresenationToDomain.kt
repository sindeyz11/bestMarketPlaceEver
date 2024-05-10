package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.UserDomain
import com.kire.market_place_android.presentation.model.User

fun User.asUserPresenationToDomain() = UserDomain(
    userId, userName, userRole.asUserRoleDomain(), userDiscount, userSpent
)