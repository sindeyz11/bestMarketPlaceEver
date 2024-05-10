package com.kire.market_place_android.presentation.screen.shopping_screen_ui

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage
import coil.request.ImageRequest

import com.kire.market_place_android.presentation.model.ProductItem
import com.kire.market_place_android.presentation.ui.theme.ExtendedTheme

import com.kire.test.R

/**
 * By Aleksey Timko (de4ltt) 28.04.24*/
@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun ItemCard(
    productItem: ProductItem,
    onClick: () -> Unit,
    onButtonClick: () -> Unit,
    @DrawableRes buttonIcon: Int
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures {
                    onClick()
                }
            },
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        productItem.apply {

            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {

                //ImageRequest should be replaced with URI
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.default_image)
                        .build(),
                    placeholder = painterResource(id = R.drawable.default_image),
                    contentDescription = "Item card image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(
                            RoundedCornerShape(
                                topStart = 15.dp,
                                topEnd = 15.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 15.dp
                            )
                        )
                        .aspectRatio(1f / 1f)
                )

                Box(
                    modifier = Modifier
                        .size(55.dp)
                        .padding(end = 10.dp, top = 10.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center,
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.favourite_top_bar),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .clickable(
                                    indication = null,
                                    interactionSource = MutableInteractionSource(),
                                    onClick = { /* TODO */ }
                                ),
                            tint = if (isFavourite) ExtendedTheme.colors.redAccent else Color.LightGray
                        )
                    }
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = itemName,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .basicMarquee(
                            animationMode = MarqueeAnimationMode.Immediately,
                            delayMillis = 0
                        )
                )

                Text(
                    text = "1$itemScale",
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .basicMarquee(
                            animationMode = MarqueeAnimationMode.Immediately,
                            delayMillis = 0
                        )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (itemPrice == itemDiscountPrice)
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 19.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            ) {
                                append("₽$itemPrice")
                            }
                        }
                    else
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            ) {
                                append("₽$itemDiscountPrice")
                            }
                            append("\n")
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    textDecoration = TextDecoration.LineThrough
                                )
                            ) {
                                append("₽$itemPrice")
                            }
                        },
                    lineHeight = if (itemPrice == itemDiscountPrice) 19.sp else 17.sp
                )

                Box(
                    modifier = Modifier
                        .size(35.dp)
                        .background(
                            ExtendedTheme.colors.redAccent,
                            RoundedCornerShape(5.dp)
                        )
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onButtonClick()
                            }
                        },
                    contentAlignment = Alignment.Center,
                    content = {
                        Icon(
                            painter = painterResource(buttonIcon),
                            contentDescription = "icon",
                            tint = Color.White,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                )
            }
        }
    }
}