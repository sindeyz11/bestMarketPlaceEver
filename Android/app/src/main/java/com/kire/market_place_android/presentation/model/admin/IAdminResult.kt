package com.kire.market_place_android.presentation.model.admin

sealed interface IAdminResult {
    class Success<T>(val data: List<T>): IAdminResult
    object SuccessfullyDone: IAdminResult
    class Error(val message: String?): IAdminResult
    object Idle: IAdminResult
}