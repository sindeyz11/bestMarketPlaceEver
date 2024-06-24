package com.kire.market_place_android.domain.model.user

sealed interface IUserResultDomain {
    class Success(val user: UserDomain): IUserResultDomain
    object SuccessfullyChanged: IUserResultDomain
    class Error(val message: String?): IUserResultDomain
    object Idle: IUserResultDomain
}