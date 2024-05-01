package com.kire.market_place_android.presentation.ui.item_add_to_cart_menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kire.market_place_android.presentation.model.ProductItem

@Composable
fun ItemsAddToCartMenuCarousel(
    itemsList: List<ProductItem>
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(itemsList) {item ->
            ItemIcon(
                imageUri = item.imageUri,
                onClick = { /* TODO */ }
            )
        }
    }
}