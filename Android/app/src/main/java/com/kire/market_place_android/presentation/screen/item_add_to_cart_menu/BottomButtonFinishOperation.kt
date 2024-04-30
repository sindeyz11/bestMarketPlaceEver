package com.kire.market_place_android.presentation.screen.item_add_to_cart_menu

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kire.market_place_android.presentation.theme.ExtendedTheme

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun BottomButtonFinishOperation(
    textValue: String,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .background(
                    color = ExtendedTheme.colors.redAccent,
                    RoundedCornerShape(13.dp)
                )
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = onClick
                ),
            content = {
                Text(
                    text = textValue,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 17.sp
                )
            },
            contentAlignment = Alignment.Center
        )
    }
}