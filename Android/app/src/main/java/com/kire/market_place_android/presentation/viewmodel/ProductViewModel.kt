package com.kire.market_place_android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.kire.market_place_android.domain.model.product.ProductDomain
import com.kire.market_place_android.domain.use_case.admin.util.IAdminUseCases
import com.kire.market_place_android.domain.use_case.common.util.ICommonUseCases
import com.kire.market_place_android.presentation.mapper.product.toDomain
import com.kire.market_place_android.presentation.mapper.product.toPresentation
import com.kire.market_place_android.presentation.mapper.toPresentation
import com.kire.market_place_android.presentation.model.IRequestResult
import com.kire.market_place_android.presentation.model.product.CartState
import com.kire.market_place_android.presentation.model.product.CartUiEvent
import com.kire.market_place_android.presentation.model.product.Product
import com.kire.market_place_android.presentation.model.product.ProductUiEvent

import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val commonUseCases: ICommonUseCases,
    private val adminUseCases: IAdminUseCases
) : ViewModel() {

    private val _requestResult: MutableStateFlow<IRequestResult> =
        MutableStateFlow(IRequestResult.Idle)
    val requestResult: StateFlow<IRequestResult> = _requestResult.asStateFlow()

    private val _allProducts: MutableStateFlow<List<Product>> = MutableStateFlow(emptyList())
    val allProducts: StateFlow<List<Product>> = _allProducts.asStateFlow()

    private val _allCategories: MutableStateFlow<Set<String>> = MutableStateFlow(emptySet())
    val allCategories: StateFlow<Set<String>> = _allCategories.asStateFlow()

    private val _chosenProduct: MutableStateFlow<Product> = MutableStateFlow(Product())
    val chosenProduct: StateFlow<Product> = _chosenProduct.asStateFlow()

    private val _cartState: MutableStateFlow<CartState> = MutableStateFlow(CartState())
    val cartState: StateFlow<CartState> = _cartState.asStateFlow()

    fun onEvent(event: CartUiEvent) {
        when (event) {
            is CartUiEvent.productSelect -> {
                if (!_cartState.value.toBuy.map { it.id }.contains(event.product.id))
                    _cartState.value = _cartState.value.copy(
                        toBuy = _cartState.value.toBuy.plusElement(event.product)
                    )
                else
                    _cartState.value = _cartState.value.copy(
                        toBuy = _cartState.value.toBuy.filter { it.id != event.product.id }
                    )
            }

            is CartUiEvent.chooseQuantity -> {
                _cartState.value = _cartState.value.copy(
                    toBuy = _cartState.value.toBuy.map {
                        if (it.id == event.productId)
                            it.copy(chosenQuantity = event.chosenQuantity)
                        else it
                    }
                )
            }

            is CartUiEvent.deleteFromCart -> {
                _cartState.value = _cartState.value.copy(
                    allProductsInCart = _cartState.value.allProductsInCart.filter { it.id != event.productId },
                    toBuy = _cartState.value.toBuy.filter { it.id != event.productId }
                )
            }

            is CartUiEvent.addToCart -> {
                if (!_cartState.value.allProductsInCart.map { it.id }.contains(event.product.id))
                    _cartState.value = _cartState.value.copy(
                        allProductsInCart = _cartState.value.allProductsInCart.plusElement(event.product),
                        toBuy = _cartState.value.toBuy.plusElement(event.product)
                    )
                else
                    _cartState.value = _cartState.value.copy(
                        toBuy = _cartState.value.toBuy.map {
                            if (it.id == event.product.id)
                                it.copy(chosenQuantity = it.chosenQuantity + event.product.chosenQuantity)
                            else it
                        }
                    )
            }

            is CartUiEvent.changeChosenProduct -> {
                _chosenProduct.value = event.chosenProduct
            }
        }
    }

    fun onEvent(event: ProductUiEvent) {
        when (event) {
            is ProductUiEvent.ItemCategoryChanged -> {
                if (event.itemCategory.matches("[а-яёА-ЯЁ]*".toRegex()))
                    _chosenProduct.value = _chosenProduct.value.copy(category = event.itemCategory)
            }

            is ProductUiEvent.ItemDescriptionChanged -> {
                if (event.itemDescription.matches("[а-яёА-ЯЁ]*".toRegex()))
                    _chosenProduct.value =
                        _chosenProduct.value.copy(description = event.itemDescription)
            }

            is ProductUiEvent.ItemDiscountPriceChanged -> {
                if (event.itemDiscountPrice.matches("[1-9]\\d*(\\.\\d{0,2})?".toRegex()))
                    _chosenProduct.value =
                        _chosenProduct.value.copy(discountPrice = event.itemDiscountPrice.toBigDecimal())
            }

            is ProductUiEvent.ItemMeasureChanged -> {
                if (event.itemUnit.matches("[а-яё]*".toRegex()))
                    _chosenProduct.value = _chosenProduct.value.copy(unit = event.itemUnit)
            }

            is ProductUiEvent.ItemNameChanged -> {
                if (event.itemName.matches("[а-яёА-ЯЁ]*".toRegex()))
                    _chosenProduct.value = _chosenProduct.value.copy(title = event.itemName)
            }

            is ProductUiEvent.ItemPriceChanged -> {
                if (event.itemPrice.matches("[1-9]\\d*(\\.\\d{0,2})?".toRegex()))
                    _chosenProduct.value =
                        _chosenProduct.value.copy(price = event.itemPrice.toBigDecimal())
            }

            is ProductUiEvent.ItemStoredChanged -> {
                if (event.itemStored.matches("\\d*".toRegex()))
                    _chosenProduct.value =
                        _chosenProduct.value.copy(quantityAvailable = event.itemStored.toInt())
            }

            is ProductUiEvent.AddItem -> {
                addProduct(event.image, event.item)
            }

            is ProductUiEvent.DeleteItem -> {
                //TODO
            }

            is ProductUiEvent.SelectItem -> {
                _chosenProduct.value = event.item
            }
        }
    }

    fun makeRequestResultIdle() {
        _requestResult.value = IRequestResult.Idle
    }

    fun refreshProducts() =
        viewModelScope.launch {
            _requestResult.value =
                commonUseCases.getAllProductsUseCase().toPresentation<List<ProductDomain>>()
                    .also { result ->
                        if (result is IRequestResult.Success<*>)
                            _allProducts.value = (result.data as List<*>).map {
                                (it as ProductDomain).toPresentation()
                            }
                    }
        }

    fun getAllCategories() =
        viewModelScope.launch {
            _requestResult.value =
                commonUseCases.getAllAvailableCategoriesUseCase().toPresentation<Set<String>>()
                    .also { result ->
                        if (result is IRequestResult.Success<*>)
                            _allCategories.value = (result.data as Set<*>).map {
                                it.toString()
                            }.toSet()
                    }
        }

    fun updateProductById(id: Int, image: ByteArray, product: Product) =
        viewModelScope.launch {
            _requestResult.value = adminUseCases.updateProductUseCase(
                id = id,
                image = image,
                product = product.toDomain()
            ).toPresentation<ProductDomain>()
        }

    fun addProduct(image: ByteArray, product: Product) =
        viewModelScope.launch {
            _requestResult.value = adminUseCases.addProductUseCase(
                image = image,
                product = product.toDomain()
            ).toPresentation<ProductDomain>()
        }
}