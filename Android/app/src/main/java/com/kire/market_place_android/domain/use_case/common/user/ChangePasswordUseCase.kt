package com.kire.market_place_android.domain.use_case.common.user

import com.kire.market_place_android.domain.model.user.IUserResultDomain
import com.kire.market_place_android.domain.repository.IUserRepository

import javax.inject.Inject

class ChangePasswordUseCase @Inject constructor(
    private val userRepository: IUserRepository
) {

    suspend operator fun invoke(
        currentPassword: String,
        newPassword: String,
        confirmationPassword: String
    ) : IUserResultDomain {
        return userRepository.changePassword(
            currentPassword = currentPassword,
            newPassword = newPassword,
            confirmationPassword = confirmationPassword
        )
    }
}