package com.kire.market_place_android.presentation.model.user

sealed class ProfileUiEvent {

    data class UsernameChanged(val value: String): ProfileUiEvent()
    data class PhoneChanged(val value: String): ProfileUiEvent()
    data class EmailChanged(val value: String): ProfileUiEvent()
    object ChangeUserInfo: ProfileUiEvent()

    data class CardNumberChanged(val value: String): ProfileUiEvent()
    data class CvcChanged(val value: String): ProfileUiEvent()
    data class ValidityChanged(val value: String): ProfileUiEvent()
    object ChangeCard: ProfileUiEvent()

    data class CurrentPasswordChanged(val value: String): ProfileUiEvent()
    data class NewPasswordChanged(val value: String): ProfileUiEvent()
    data class ConfirmationPasswordChanged(val value: String): ProfileUiEvent()
    object ChangePassword: ProfileUiEvent()
}