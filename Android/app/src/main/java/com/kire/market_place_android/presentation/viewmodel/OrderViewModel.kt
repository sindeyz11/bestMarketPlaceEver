package com.kire.market_place_android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kire.market_place_android.domain.use_case.common.util.CommonUseCases
import com.kire.market_place_android.presentation.mapper.order.toDomain
import com.kire.market_place_android.presentation.model.order.IOrderResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val commonUseCases: CommonUseCases
): ViewModel() {

    private val _orderResult: MutableStateFlow<IOrderResult> = MutableStateFlow(IOrderResult.Idle)
    val orderResult: StateFlow<IOrderResult> = _orderResult.asStateFlow()

    fun getOrders() =
        viewModelScope.launch {
            _orderResult.value = commonUseCases.getOrdersUseCase().toDomain()
        }

//    init {
//        getOrders()
//    }
}