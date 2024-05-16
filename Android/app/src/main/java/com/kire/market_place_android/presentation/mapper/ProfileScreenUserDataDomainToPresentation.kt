package com.kire.market_place_android.presentation.mapper

import com.kire.market_place_android.domain.model.ProfileScreenUserDataDomain
import com.kire.market_place_android.presentation.model.ProfileScreenUserData

/**
 * By Aleksey Timko (de4ltt)*/
fun ProfileScreenUserDataDomain.asProfileScreenUserDataPresentation() = ProfileScreenUserData(
    name = name,
    phone = phone,
    email = email,
    totalPurchases = totalPurchases,
    totalPurchasesPercent = totalPurchasesPercent,
    discount = discount
)