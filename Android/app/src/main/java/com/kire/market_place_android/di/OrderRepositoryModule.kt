package com.kire.market_place_android.di

import com.kire.market_place_android.data.repository.OrderRepository
import com.kire.market_place_android.data.repository.PickUpPointRepository
import com.kire.market_place_android.domain.repository.IOrderRepository
import com.kire.market_place_android.domain.repository.IPickUpPointRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class OrderRepositoryModule {

    @Binds
    abstract fun provideOrderRepository(orderRepository: OrderRepository): IOrderRepository
}