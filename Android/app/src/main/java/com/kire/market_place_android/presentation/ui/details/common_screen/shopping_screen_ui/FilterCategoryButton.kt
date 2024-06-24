package com.kire.market_place_android.presentation.ui.details.common_screen.shopping_screen_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

import com.kire.market_place_android.presentation.model.product.Category
import com.kire.market_place_android.presentation.ui.theme.ExtendedTheme

/**
 * By Aleksey Timko (de4ltt)*/
@Composable
fun FilterCategoryButton(
    category: Category,
    onClick: (Category) -> Unit,
    isChecked: Boolean
) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .background(
                color = if (isChecked) ExtendedTheme.colors.redAccentSoft else ExtendedTheme.colors.profileBar,
                shape = RoundedCornerShape(5.dp)
            )
            .pointerInput(Unit) {
                detectTapGestures {
                    onClick(category)
                }
            },
        contentAlignment = Alignment.Center,
        content = {
            Text(
                modifier = Modifier.padding(8.dp),
                text = category.title
            )
        }
    )
}