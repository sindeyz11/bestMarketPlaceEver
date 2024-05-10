package com.kire.market_place_android.domain.model

data class UserDomain(
    val userId: Int,
    val userName: String,
    val userRole: UserRoleDomain,
    val userDiscount: Int,
    val userSpent: Double
)