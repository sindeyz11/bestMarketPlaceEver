package com.kire.market_place_android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.kire.market_place_android.domain.model.product.CategoryDomain
import com.kire.market_place_android.domain.model.product.ProductDomain
import com.kire.market_place_android.domain.use_case.common.util.ICommonUseCases
import com.kire.market_place_android.presentation.mapper.product.toPresentation
import com.kire.market_place_android.presentation.mapper.toPresentation
import com.kire.market_place_android.presentation.model.IRequestResult
import com.kire.market_place_android.presentation.model.product.Category
import com.kire.market_place_android.presentation.model.product.Product

import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val commonUseCases: ICommonUseCases
): ViewModel() {

    private val _requestResult: MutableStateFlow<IRequestResult> = MutableStateFlow(IRequestResult.Idle)
    val requestResult: StateFlow<IRequestResult> = _requestResult.asStateFlow()

    private val _allProducts: MutableStateFlow<List<Product>> = MutableStateFlow(emptyList())
    val allProducts: StateFlow<List<Product>> = _allProducts.asStateFlow()

    private val _allCategories: MutableStateFlow<List<Category>> = MutableStateFlow(emptyList())
    val allCategories: StateFlow<List<Category>> = _allCategories.asStateFlow()

    fun refreshProducts() =
        viewModelScope.launch {
            _requestResult.value = commonUseCases.getAllProductsUseCase().toPresentation<List<ProductDomain>>()
                .also { result ->
                    if (result is IRequestResult.Success<*>)
                        _allProducts.value = (result.data as List<*>).map {
                            (it as ProductDomain).toPresentation()
                        }
                }
        }

    fun getAllCategories() =
        viewModelScope.launch {
            _requestResult.value = commonUseCases.getAllAvailableCategoriesUseCase().toPresentation<List<CategoryDomain>>()
                .also { result ->
                    if (result is IRequestResult.Success<*>)
                        _allCategories.value = (result.data as List<*>).map {
                            (it as CategoryDomain).toPresentation()
                        }
                }
        }

//    init {
//        refreshProducts()
//    }
}