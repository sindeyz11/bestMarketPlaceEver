package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.UserDomain
import com.kire.market_place_android.presentation.model.User

/**
 * By Aleksey Timko (de4ltt)*/
fun UserDomain.asUserPresentation() = User(
    userId = userId,
    userName = userName,
    userRole = userRole.asUserRolePresentation(),
    userDiscount = userDiscount,
    userSpent = userSpent
)