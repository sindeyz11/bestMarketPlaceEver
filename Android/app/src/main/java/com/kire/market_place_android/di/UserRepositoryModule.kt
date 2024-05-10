package com.kire.market_place_android.di

import com.kire.market_place_android.data.repository.UserRepository
import com.kire.market_place_android.domain.repository.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {

    @Binds
    abstract fun provideUserRepository(userRepository: UserRepository): IUserRepository
}