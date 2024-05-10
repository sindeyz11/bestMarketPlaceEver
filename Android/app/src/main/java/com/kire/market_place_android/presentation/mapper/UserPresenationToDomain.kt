package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.UserDomain
import com.kire.market_place_android.presentation.model.User

/**
 * By Aleksey Timko (de4ltt)*/
fun User.asUserPresentationToDomain() = UserDomain(
    userId = userId,
    userName = userName,
    userRole = userRole.asUserRoleDomain(),
    userDiscount = userDiscount,
    userSpent = userSpent
)