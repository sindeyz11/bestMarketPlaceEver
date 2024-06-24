package com.kire.market_place_android.domain.use_case.common.user

import com.kire.market_place_android.domain.model.user.IUserResultDomain
import com.kire.market_place_android.domain.repository.IUserRepository
import javax.inject.Inject

class ChangeUserInfoAndReturnUseCase @Inject constructor(
    private val userRepository: IUserRepository
) {
    suspend operator fun invoke(
        id: Int,
        username: String,
        phone: String,
        email: String
    ): IUserResultDomain {

        userRepository.changeUserInfo(
            id = id,
            username = username,
            phone = phone,
            email = email
        )

        return userRepository.getUserInfo(id)
    }
}

