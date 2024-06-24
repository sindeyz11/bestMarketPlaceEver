package com.kire.market_place_android.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kire.market_place_android.domain.model.admin.AdminUserInfoDomain
import com.kire.market_place_android.domain.model.pick_up_point.PickUpPointDomain

import com.kire.market_place_android.domain.use_case.admin.util.IAdminUseCases
import com.kire.market_place_android.presentation.mapper.admin.toPresentation
import com.kire.market_place_android.presentation.mapper.pick_up_point.toPresentation
import com.kire.market_place_android.presentation.model.pick_up_point.PickUpPoint
import com.kire.market_place_android.presentation.model.admin.AdminState
import com.kire.market_place_android.presentation.model.admin.AdminUiEvent
import com.kire.market_place_android.presentation.model.admin.AdminUserInfo
import com.kire.market_place_android.presentation.model.admin.IAdminResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class AdminViewModel @Inject constructor(
    private val adminUseCases: IAdminUseCases
): ViewModel() {

    private val _allUsers: MutableStateFlow<List<AdminUserInfo>> = MutableStateFlow(emptyList())
    val allUsers: StateFlow<List<AdminUserInfo>> = _allUsers.asStateFlow()

    private val _allPickUpPoints: MutableStateFlow<List<PickUpPoint>> = MutableStateFlow(emptyList())
    val allPickUpPoints: StateFlow<List<PickUpPoint>> = _allPickUpPoints.asStateFlow()

    private val _adminResult: MutableStateFlow<IAdminResult> = MutableStateFlow(IAdminResult.Idle)
    val adminResult: StateFlow<IAdminResult> = _adminResult.asStateFlow()

    var adminState by mutableStateOf(AdminState())

    fun onEvent(event: AdminUiEvent){
        when(event){
            is AdminUiEvent.ChangeOnDismissRequest -> {
                adminState = adminState.copy(onDismissRequest = event.value)
            }
            is AdminUiEvent.DeletePickUpPoint -> {
                viewModelScope.launch {
                    deletePickUpPoint(id = event.id).join()
                    getAllPickUpPoints()
                }
            }
            is AdminUiEvent.CreatePickUpPoint -> {
                viewModelScope.launch {
                    createPickUpPoint(managerId = event.managerId, address = event.address).join()
                    getAllPickUpPoints()
                }

            }

            is AdminUiEvent.ChangeIsCreateBottomBarExpanded -> {
                adminState = adminState.copy(isCreateBottomBarExpanded = event.value, bottomBarManagerId = "")
            }

            is AdminUiEvent.ChangeIsUpdateBottomBarExpanded -> {
                adminState = adminState.copy(
                    isUpdateBottomBarExpanded = event.value,
                    pickUpPointToUpdateId = event.pickUpPointToUpdateId,
                    bottomBarAddress = event.address
                )
            }

            is AdminUiEvent.bottomBarManagerIdChanged -> {
                adminState = adminState.copy(bottomBarManagerId = event.value)
            }

            is AdminUiEvent.bottomBarAddressChanged -> {
                adminState = adminState.copy(bottomBarAddress = event.value)
            }

            is AdminUiEvent.UpdatePickUpPoint -> {
                viewModelScope.launch {
                    updatePickUpPoint(id = event.pickUpPointToUpdateId, managerId = event.managerId, address = event.address).join()
                    getAllPickUpPoints()
                }
            }

        }
    }

    fun getAllUsers() =
        viewModelScope.launch {
            _adminResult.value = adminUseCases.getAllUsersUseCase().toPresentation<AdminUserInfo>()
                .also { result ->
                    if (result is IAdminResult.Success<*>)
                        _allUsers.value = result.data.map {
                            (it as AdminUserInfoDomain).toPresentation()
                        }
                }
        }

    fun getAllPickUpPoints() =
        viewModelScope.launch {
            _adminResult.value = adminUseCases.getAllPickUpPointsUseCase().toPresentation<PickUpPoint>()
                .also { result ->
                    if (result is IAdminResult.Success<*>)
                        _allPickUpPoints.value = result.data.map {
                            (it as PickUpPointDomain).toPresentation()
                        }
                }
        }

    fun createPickUpPoint(managerId: Int, address: String) =
        viewModelScope.launch {
            _adminResult.value = adminUseCases.createPickUpPointUseCase(managerId = managerId, address = address).toPresentation<Nothing>()
        }

    fun updatePickUpPoint(id: Int, address: String, managerId: Int) =
        viewModelScope.launch {
            _adminResult.value = adminUseCases.updatePickUpPointUseCase(id = id, address = address, managerId = managerId).toPresentation<Nothing>()
        }

    fun deletePickUpPoint(id: Int) =
        viewModelScope.launch {
            _adminResult.value = adminUseCases.deletePickUpPointUseCase(id = id).toPresentation<Nothing>()
        }
}