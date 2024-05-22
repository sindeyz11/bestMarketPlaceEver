package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.UserDomain
import com.kire.market_place_android.domain.model.UserRoleDomain
import com.kire.market_place_android.presentation.model.UserRole

/**
 * By Aleksey Timko (de4ltt)*/
fun UserRole.asUserRoleDomain() = UserRoleDomain.valueOf(this.name)