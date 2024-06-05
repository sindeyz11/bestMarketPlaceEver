package com.kire.market_place_android.presentation.model

/**
 * By Aleksey Timko (de4ltt)*/
data class User(
    val userId: Int,
    val userName: String,
    val userRole: UserRole,
    val userDiscount: Int,
    val userSpent: Double
)