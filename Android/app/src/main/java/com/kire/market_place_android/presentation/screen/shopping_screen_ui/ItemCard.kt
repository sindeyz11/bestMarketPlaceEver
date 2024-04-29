package com.kire.market_place_android.presentation.screen.shopping_screen_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kire.market_place_android.presentation.model.ProductItem
import com.kire.market_place_android.presentation.screen.destinations.ItemAddToCartMenuDestination
import com.kire.market_place_android.presentation.theme.ExtendedTheme
import com.kire.test.R
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * By Aleksey Timko (de4ltt) 28.04.24*/
@Composable
fun ItemCard(
    productItem: ProductItem,
    navigator: DestinationsNavigator
) {

    Card(
        modifier = Modifier
            .width(128.dp)
            .height(260.dp)
            .pointerInput(Unit) {
                detectTapGestures {
                    navigator.navigate(ItemAddToCartMenuDestination)
                }
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RectangleShape
    ) {
        productItem.apply {
            AsyncImage(
                model = imageUri,
                placeholder = painterResource(id = R.drawable.default_image),
                contentDescription = "Item image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(165.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 15.dp,
                            topEnd = 15.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 15.dp
                        )
                    )
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        )
                    ) {
                        append(itemName)
                    }
                    append("\n")

                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    ) {
                        append("1$itemScale")
                    }
                },
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(38.dp),
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
                            color = ExtendedTheme.colors.redAccent,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .clickable { },
                    contentAlignment = Alignment.Center,
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.plus),
                            contentDescription = "Plus",
                            tint = Color.White
                        )
                    }
                )
            }
        }

    }
}

