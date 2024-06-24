package com.kire.market_place_android.presentation.model.admin

sealed class AdminUiEvent {

    data class ChangeOnDismissRequest(val value: Boolean): AdminUiEvent()
    data class DeletePickUpPoint(val id: Int): AdminUiEvent()
    data class CreatePickUpPoint(val managerId: Int, val address: String): AdminUiEvent()

    data class ChangeIsCreateBottomBarExpanded(val value: Boolean): AdminUiEvent()
    data class ChangeIsUpdateBottomBarExpanded(val value: Boolean, val pickUpPointToUpdateId: String, val address: String): AdminUiEvent()

    data class bottomBarAddressChanged(val value: String): AdminUiEvent()
    data class bottomBarManagerIdChanged(val value: String): AdminUiEvent()
    data class UpdatePickUpPoint(val pickUpPointToUpdateId: Int, val managerId: Int, val address: String): AdminUiEvent()
}
