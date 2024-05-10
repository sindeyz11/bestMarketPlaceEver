package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.UserDomain
import com.kire.market_place_android.presentation.model.User

fun UserDomain.asUserPresentation() = User(
    userId, userName, userRole.asUserRolePresentation(), userDiscount, userSpent
)