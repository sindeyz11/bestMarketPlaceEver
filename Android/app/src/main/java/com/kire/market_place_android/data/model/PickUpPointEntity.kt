package com.kire.market_place_android.data.model


/**
 * By Aleksey Timko (de4ltt)*/
data class PickUpPointEntity(
    val id: Int,
    val adress: String,
    val manager: UserEntity,
    val income: Double
)