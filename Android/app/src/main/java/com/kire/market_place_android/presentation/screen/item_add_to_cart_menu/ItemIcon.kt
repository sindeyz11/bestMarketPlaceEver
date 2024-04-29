package com.kire.market_place_android.presentation.screen.item_add_to_cart_menu

import android.annotation.SuppressLint

import android.net.Uri

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

import coil.compose.AsyncImage

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun ItemIcon(
    imageUri: Uri?,
    onClick: () -> Unit
) {
    AsyncImage(
        model = { },
        /*placeholder = painterResource(id = R.drawable.default_image) ,*/
        contentDescription = "Item Cart Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(120.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 15.dp
                )
            )
            .background(Color.LightGray)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = onClick
            )
    )
}