package com.kire.market_place_android.presentation.mapper.user

import com.kire.market_place_android.domain.model.user.IUserResultDomain
import com.kire.market_place_android.presentation.model.user.IUserResult

fun IUserResultDomain.toDomain() =

    when(this){
        is IUserResultDomain.Success -> {
            IUserResult.Success(this.user.toPresentation())
        }

        IUserResultDomain.SuccessfullyChanged -> {
            IUserResult.SuccessfullyChanged
        }

        is IUserResultDomain.Error -> {
            IUserResult.Error(this.message)
        }
        IUserResultDomain.Idle -> {
            IUserResult.Idle
        }
    }