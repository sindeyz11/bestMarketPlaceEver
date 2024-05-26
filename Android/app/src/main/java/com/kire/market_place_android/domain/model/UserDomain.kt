package com.kire.market_place_android.domain.model

/**
 * By Aleksey Timko (de4ltt)*/
data class UserDomain(
    val userId: Int,
    val userName: String,
    val userRole: UserRoleDomain,
    val userDiscount: Int,
    val userSpent: Double
)