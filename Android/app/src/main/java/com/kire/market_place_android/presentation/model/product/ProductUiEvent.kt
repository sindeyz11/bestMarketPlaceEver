package com.kire.market_place_android.presentation.model.product

sealed class ProductUiEvent {

    data class ItemNameChanged(var itemName: String): ProductUiEvent()
    data class ItemCategoryChanged(var itemCategory: String): ProductUiEvent()
    data class ItemPriceChanged(var itemPrice: String): ProductUiEvent()
    data class ItemDiscountPriceChanged(var itemDiscountPrice: String): ProductUiEvent()
    data class ItemMeasureChanged(var itemUnit: String): ProductUiEvent()
    data class ItemStoredChanged(var itemStored: String): ProductUiEvent()
    data class ItemDescriptionChanged(var itemDescription: String): ProductUiEvent()

    data class SelectItem(val item: Product): ProductUiEvent()
    data class AddItem(var image: ByteArray, var item: Product): ProductUiEvent()
    data class DeleteItem(var item: Product): ProductUiEvent()
}