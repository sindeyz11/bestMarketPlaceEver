package com.kire.market_place_android.presentation.ui.screen.common

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.kire.market_place_android.presentation.model.product.Product
import com.kire.market_place_android.presentation.navigation.transition.ShoppingCartScreenTransitions
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.ui.details.common_screen.cross_screen_ui.OnScrollListener
import com.kire.market_place_android.presentation.ui.details.common_screen.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.ui.details.common_screen.shopping_cart_screen_ui.OrderingBottomBar
import com.kire.market_place_android.presentation.ui.details.common_screen.shopping_cart_screen_ui.PurchaseFloatingActionButton
import com.kire.market_place_android.presentation.ui.details.common_screen.shopping_cart_screen_ui.ShoppingCartItem
import com.kire.market_place_android.presentation.ui.screen.destinations.ItemAddToCartMenuDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ShoppingScreenDestination
import com.kire.market_place_android.presentation.viewmodel.UserViewModel

import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.utils.isRouteOnBackStack

/**
 * By Michael Gontarev (KiREHwYE)*/
@OptIn(ExperimentalMaterial3Api::class)
@Destination(style = ShoppingCartScreenTransitions::class)
@Composable
fun ShoppingCartScreen(
    userViewModel: UserViewModel,
    navController: NavController,
    shoppingCartItems: List<Product> = listOf(
        Product(),
    ),
    paddingValues: PaddingValues = PaddingValues(start = 28.dp, end = 28.dp, bottom = 66.dp)
) {

    BackHandler {
        if (navController.isRouteOnBackStack(ItemAddToCartMenuDestination))
            navController.popBackStack(ItemAddToCartMenuDestination, inclusive = false)
        else
            navController.popBackStack(ShoppingScreenDestination, inclusive = false)
        return@BackHandler
    }

    val isBottomSheetShown = remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState()
    
    val listState = rememberLazyListState()

    val isShown = remember {
        mutableStateOf(true)
    }

    OnScrollListener(
        listState = listState,
        isShown = {
            isShown.value = it
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBar(destination = AppDestinations.BottomBarDestinations.SHOPPING_CART)

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f, fill = false),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            when(shoppingCartItems.size) {
                0 -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                        content = {
                            Text(
                                text = stringResource(R.string.nothing_was_found),
                                fontSize = 16.sp,
                                color = Color.DarkGray
                            )
                        }
                    )
                }
                else -> {

                    LazyColumn(
                        state = listState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        contentPadding = PaddingValues(bottom = 28.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        itemsIndexed(
                            shoppingCartItems,
                            key = null
                        ) { index, item ->

                            ShoppingCartItem(
                                name = item.title,
                                price = item.price.toString(),
                                amount = 3.0
                            )
                        }
                    }
                }
            }
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 86.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        AnimatedVisibility(
            visible = isShown.value,
            enter =
            slideInVertically(
                initialOffsetY = {height -> -height},
                animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
            ) + fadeIn(animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)),
            exit = slideOutVertically(
                targetOffsetY = {height -> height},
                animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
            ) + fadeOut(animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing))
        ) {

        PurchaseFloatingActionButton(
                onClick = {
                    isBottomSheetShown.value = true
                }
            )
        }
    }
    
    if (isBottomSheetShown.value)
        OrderingBottomBar(
            showBottomSheet = {
                isBottomSheetShown.value = false
            },
            sheetState = sheetState
        )
    
}