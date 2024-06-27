package com.kire.market_place_android.presentation.ui.details.common.item_add_to_cart_menu_ui

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kire.market_place_android.presentation.model.product.Product

/**
 * Карусель с товарами на экране товара
 *
 * @param itemsList Список товаров
 *
 * @author Aleksey Timko (de4ltt)*/
@Composable
fun ItemsAddToCartMenuCarousel(
    itemsList: List<Product>
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(itemsList) {item ->
            ItemIcon(
                imageUri = Uri.parse(item.imageUrl),
                onClick = { /* TODO */ }
            )
        }
    }
}