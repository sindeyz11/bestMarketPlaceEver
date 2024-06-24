package com.kire.market_place_android.domain.model.admin

sealed interface IAdminResultDomain {
    class Success<T>(val data: List<T>): IAdminResultDomain
    object SuccessfullyDone: IAdminResultDomain
    class Error(val message: String?): IAdminResultDomain
    object Idle: IAdminResultDomain
}