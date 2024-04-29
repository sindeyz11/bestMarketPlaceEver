package com.kire.market_place_android.presentation.screen.item_add_to_cart_menu

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kire.market_place_android.presentation.theme.ExtendedTheme
import com.kire.test.R

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun ProductItemCounter(
    curItemCount: Int,
    onPlusAction: () -> Unit,
    onMinusAction: () -> Unit
) {
    Row(
        modifier = Modifier
            .size(
                width = 120.dp,
                height = 40.dp
            )
            .background(
                color = ExtendedTheme.colors.black10,
                RoundedCornerShape(12.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painter = painterResource(id = R.drawable.minus),
            contentDescription = "Minus",
            tint = Color.DarkGray,
            modifier = Modifier
                .width(40.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = onMinusAction
                )
        )

        Text(
            text = curItemCount.toString(),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

        Icon(
            painter = painterResource(id = R.drawable.plus),
            contentDescription = "Minus",
            tint = Color.DarkGray,
            modifier = Modifier
                .width(40.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = onPlusAction
                )
        )
    }
}