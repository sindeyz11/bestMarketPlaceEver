package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.ProfileScreenUserDataDomain
import com.kire.market_place_android.presentation.model.ProfileScreenUserData

fun ProfileScreenUserData.asProfileScreenUserDataDomain() = ProfileScreenUserDataDomain(
    name, phone, email, totalPurchases, totalPurchasesPercent, discount
)