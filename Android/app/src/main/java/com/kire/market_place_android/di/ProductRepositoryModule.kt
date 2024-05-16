package com.kire.market_place_android.di

import com.kire.market_place_android.data.repository.LoginRepository
import com.kire.market_place_android.data.repository.ProductRepository
import com.kire.market_place_android.domain.repository.ILoginRepository
import com.kire.market_place_android.domain.repository.IProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * By Michael Gontarev (KiREHwYE)*/
@Module
@InstallIn(SingletonComponent::class)
abstract class ProductRepositoryModule {

    @Binds
    abstract fun provideProductRepository(productRepository: ProductRepository): IProductRepository
}