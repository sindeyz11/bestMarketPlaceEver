package com.kire.market_place_android.presentation.viewmodel

import androidx.lifecycle.ViewModel

import com.kire.market_place_android.domain.use_case.common.util.ICommonUseCases
import com.kire.market_place_android.domain.use_case.manager.util.IManagerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class ManagerViewModel @Inject constructor(
    private val managerUseCases: IManagerUseCases,
    private val commonUseCases: ICommonUseCases
): ViewModel() {

}