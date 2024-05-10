package com.kire.market_place_android.di

import com.kire.market_place_android.data.repository.LoginRepository
import com.kire.market_place_android.domain.repository.ILoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginRepositoryModule {

    @Binds
    abstract fun provideLoginRepository(loginRepository: LoginRepository): ILoginRepository
}