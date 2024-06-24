package com.kire.market_place_android.presentation.mapper.admin

import com.kire.market_place_android.domain.model.admin.IAdminResultDomain
import com.kire.market_place_android.presentation.model.admin.IAdminResult

fun <T> IAdminResultDomain.toPresentation() =
    when(this) {
        is IAdminResultDomain.Success<*> -> {
            @Suppress("UNCHECKED_CAST")
            IAdminResult.Success(this.data as List<T>)
        }

        IAdminResultDomain.SuccessfullyDone ->
            IAdminResult.SuccessfullyDone

        IAdminResultDomain.Idle ->
            IAdminResult.Idle

        is IAdminResultDomain.Error ->
            IAdminResult.Error(this.message)
    }