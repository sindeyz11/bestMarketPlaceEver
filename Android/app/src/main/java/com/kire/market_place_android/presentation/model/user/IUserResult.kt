package com.kire.market_place_android.presentation.model.user

sealed interface IUserResult {
    class Success(val user: User): IUserResult
    object SuccessfullyChanged: IUserResult
    class Error(val message: String?): IUserResult
    object Idle: IUserResult
}