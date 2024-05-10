package com.kire.market_place_android.domain.use_case.admin

import com.kire.market_place_android.domain.repository.IProductRepository
import javax.inject.Inject

class DeleteProductUseCase @Inject constructor(
    private val productRepository: IProductRepository
) {
    operator fun invoke() {
        /*TODO*/
    }
}