package com.kire.market_place_android.data.remote.dto

import java.lang.Exception

data class Error(
    override val message: String
): Exception()
