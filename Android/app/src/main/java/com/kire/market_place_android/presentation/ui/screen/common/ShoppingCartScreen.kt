package com.kire.market_place_android.presentation.ui.screen.common

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.gestures.detectTapGestures

import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import androidx.navigation.NavController
import com.kire.market_place_android.presentation.model.order.OrderedProduct

import com.kire.market_place_android.presentation.model.product.Product
import com.kire.market_place_android.presentation.navigation.transition.common.ShoppingCartScreenTransitions
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.ListWithTopAndFab
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.RequestResultMessage
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.ui.details.common.shopping_cart_screen_ui.OrderingBottomBar
import com.kire.market_place_android.presentation.ui.details.common.shopping_cart_screen_ui.PurchaseFloatingActionButton
import com.kire.market_place_android.presentation.ui.details.common.shopping_cart_screen_ui.ShoppingCartItem
import com.kire.market_place_android.presentation.ui.screen.destinations.ItemAddToCartMenuDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ShoppingScreenDestination
import com.kire.market_place_android.presentation.viewmodel.UserViewModel

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import java.math.BigDecimal

/**
 * Корзина покупок
 *
 * @param userViewModel ViewModel для работы с пользователем
 * @param navController NavController для навигации между экранами
 * @param shoppingCartItems список товаров в корзине
 * @param paddingValues отступы от краев экрана
 *
 * @author Michael Gontarev (KiREHwYE)*/
@OptIn(ExperimentalMaterial3Api::class)
@Destination(style = ShoppingCartScreenTransitions::class)
@Composable
fun ShoppingCartScreen(
    userViewModel: UserViewModel,
    createOrder: (pickUpPointId: Int, orderedProducts: List<OrderedProduct>, orderPrice: BigDecimal) -> Unit,
    navController: NavController,
    shoppingCartItems: List<Product> = listOf(
        Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product()
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

    val sheetState = rememberModalBottomSheetState()
    val isBottomSheetShown = remember {
        mutableStateOf(false)
    }

    val requestResult by userViewModel.requestResult.collectAsStateWithLifecycle()

    RequestResultMessage(requestResult = requestResult)

    ListWithTopAndFab(
        listSize = shoppingCartItems.size,
        paddingValues = paddingValues,
        topBar = {
            TopBar(destination = AppDestinations.BottomBarDestinations.SHOPPING_CART)
        },
        floatingButton = { shiftBarDown ->
            PurchaseFloatingActionButton(
                onClick = {
                    isBottomSheetShown.value = true
                },
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures {
//                            createOrder()
                        }
                        detectVerticalDragGestures { change, dragAmount ->
                            if (dragAmount > 0) {
                                shiftBarDown()
                            }
                        }
                    }
            )
        }
    ) {
        LazyColumn(
            modifier = it,
            contentPadding = PaddingValues(bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            items(
                shoppingCartItems,
//                key = {it.id}
            ) {item ->

                ShoppingCartItem(
                    name = item.title,
                    price = item.price.toString(),
                    amount = 3.0
                )
            }
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