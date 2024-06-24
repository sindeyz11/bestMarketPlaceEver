package com.kire.market_place_android.presentation.mapper.product

import com.kire.market_place_android.domain.model.product.IProductResultDomain
import com.kire.market_place_android.presentation.model.product.IProductResult

fun <T> IProductResultDomain.toPresentation() =
    when(this) {
        is IProductResultDomain.Success<*> -> {
            @Suppress("UNCHECKED_CAST")
            IProductResult.Success(this.data as List<T>)
        }
        IProductResultDomain.SuccessfullyDone -> {
            IProductResult.SuccessfullyDone
        }
        IProductResultDomain.Idle -> {
            IProductResult.Idle
        }
        is IProductResultDomain.Error -> {
            IProductResult.Error(this.message)
        }
    }