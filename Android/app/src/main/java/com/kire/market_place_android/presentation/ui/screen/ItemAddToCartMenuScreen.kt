package com.kire.market_place_android.presentation.ui.screen

import android.net.Uri

import androidx.activity.compose.BackHandler

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage
import coil.request.ImageRequest

import com.kire.market_place_android.presentation.destinations.AdminPanelItemsEditScreenDestination
import com.kire.market_place_android.presentation.destinations.ItemAddToCartMenuDestination
import com.kire.market_place_android.presentation.destinations.ShoppingCartScreenDestination
import com.kire.market_place_android.presentation.model.ProductItem
import com.kire.market_place_android.presentation.navigation.Transition.ItemAddToCartMenuScreenTransitions
import com.kire.market_place_android.presentation.ui.admin_panel_items_edit_screen_ui.AdminEditTopControls
import com.kire.market_place_android.presentation.ui.item_add_to_cart_menu.BottomButtonFinishOperation
import com.kire.market_place_android.presentation.ui.item_add_to_cart_menu.ItemsAddToCartMenuCarousel
import com.kire.market_place_android.presentation.ui.item_add_to_cart_menu.ProductItemCounter
import com.kire.market_place_android.presentation.ui.theme.ExtendedTheme

import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * By Michael Gontarev (KiREHwYE)
 * By Aleksey Timko (de4ltt)*/
@OptIn(ExperimentalFoundationApi::class)
@Destination(style = ItemAddToCartMenuScreenTransitions::class)
@Composable
fun ItemAddToCartMenu(
    productItem: ProductItem = ProductItem(
        "Помидоры", "250.00",
        "кг", "250.00",
        Uri.EMPTY, false,
        "Помогите, они украли мою семью..."
    ),
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues = PaddingValues(28.dp)
) {

    BackHandler {
        navigator.popBackStack()
        return@BackHandler
    }

    val scrollState = rememberScrollState()

    var productItemCount by remember {
        mutableStateOf(1)
    }

    productItem.apply {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .pointerInput(Unit) {
                    detectVerticalDragGestures { _, dragAmount ->

                        val y = dragAmount

                        if (y > 60) {
                            navigator.popBackStack(
                                ItemAddToCartMenuDestination,
                                inclusive = true
                            )
                        }
                    }
                },
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            //ImageRequest should be replaced with URI
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.item_menu_default)
                    .build(),
                placeholder = painterResource(id = R.drawable.item_menu_default),
                contentDescription = "Shopping cart item image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f / 1.1f)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .offset(y = -25.dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(
                            topStart = 25.dp,
                            topEnd = 25.dp
                        )
                    )
                    .padding(top = 28.dp, bottom = 28.dp)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 28.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(1f),
                            horizontalAlignment = Alignment.Start
                        ) {

                            Text(
                                text = itemName,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .basicMarquee(
                                        animationMode = MarqueeAnimationMode.Immediately,
                                        delayMillis = 0
                                    )
                            )

                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = ExtendedTheme.colors.greenPrice,
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.ExtraBold
                                        )
                                    ) {
                                        append("₽$itemPrice")
                                    }

                                    append("\t\t")

                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            color = Color.DarkGray,
                                            fontSize = 21.sp
                                        )
                                    ) {
                                        append("1$itemScale")
                                    }
                                }
                            )
                        }

                        ProductItemCounter(
                            productItemCount,
                            { productItemCount++ },
                            {
                                productItemCount =
                                    if (productItemCount == 0) 0 else --productItemCount
                            }
                        )
                    }

                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(stringResource(id = R.string.description))
                            }

                            append("\n")

                            withStyle(
                                style = SpanStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.DarkGray
                                )
                            ) {
                                append(itemDescription)
                            }
                        },
                        maxLines = 2,
                        modifier = Modifier.padding(start = 28.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(bottom = 28.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.Start
                    ) {

                        Text(
                            text = stringResource(id = R.string.items_from_this_category),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 28.dp)
                        )

                        //TODO
                        //temporary
                        val itemsList: List<ProductItem> = listOf(
                            ProductItem(
                                "Помидоры",
                                "250.00",
                                "кг",
                                "250.00",
                                Uri.EMPTY,
                                false,
                                ""
                            ),
                            ProductItem(
                                "Груши",
                                "300.00",
                                "кг",
                                "250.00",
                                Uri.EMPTY,
                                true,
                                ""
                            ),
                            ProductItem(
                                "Помидоры",
                                "250.00",
                                "кг",
                                "300.00",
                                Uri.EMPTY,
                                true,
                                ""
                            ),
                            ProductItem(
                                "Груши",
                                "300.00",
                                "кг",
                                "250.00",
                                Uri.EMPTY,
                                false,
                                ""
                            ),
                            ProductItem(
                                "Помидоры",
                                "250.00",
                                "кг",
                                "250.00",
                                Uri.EMPTY,
                                false,
                                ""
                            ),
                            ProductItem(
                                "Груши",
                                "300.00",
                                "кг",
                                "250.00",
                                Uri.EMPTY,
                                true,
                                ""
                            )
                        )

                        ItemsAddToCartMenuCarousel(itemsList = itemsList)
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 28.dp, start = 28.dp, end = 28.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomButtonFinishOperation(
                textValue = stringResource(id = R.string.add_to_cart) + " - " + "₽" + "${itemPrice.toDouble() * productItemCount}",
                onClick = {
                    navigator.navigate(ShoppingCartScreenDestination)
                }
            )
        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopStart
        ) {

            AdminEditTopControls(
                onArrowBackClick = {
                    navigator.popBackStack()
                },
                rightButton = {
                    Icon(
                        painter = painterResource(id = R.drawable.favourite_top_bar),
                        contentDescription = "update_sign",
                        modifier = Modifier
                            .size(24.dp)
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    //TODO
                                }
                            },
                        tint = ExtendedTheme.colors.redAccent
                    )
                }
            )
        }
    }
}

