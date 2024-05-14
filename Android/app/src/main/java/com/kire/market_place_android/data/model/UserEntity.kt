package com.kire.market_place_android.data.model

/**
 * By Aleksey Timko (de4ltt)*/
data class UserEntity(
    val userId: Int,
    val userName: String,
    val userRole: UserRoleEntity,
    val userDiscount: Int,
    val userSpent: Double
)