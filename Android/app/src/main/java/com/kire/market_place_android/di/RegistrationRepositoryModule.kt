package com.kire.market_place_android.di

import com.kire.market_place_android.data.repository.RegistrationRepository
import com.kire.market_place_android.domain.repository.IRegistrationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RegistrationRepositoryModule {

    @Binds
    abstract fun provideRegistrationRepository(registrationRepository: RegistrationRepository): IRegistrationRepository
}