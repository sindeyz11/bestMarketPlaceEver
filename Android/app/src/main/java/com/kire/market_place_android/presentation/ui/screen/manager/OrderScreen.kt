package com.kire.market_place_android.presentation.ui.screen.manager

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.gestures.detectVerticalDragGestures

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

import com.kire.market_place_android.presentation.model.product.Product
import com.kire.market_place_android.presentation.navigation.transition.manager.OrderScreenTransitions
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.ListWithTopAndFab
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.ui.details.manager.order_screen_ui.OrderFloatingButton
import com.kire.market_place_android.presentation.ui.details.manager.order_screen_ui.OrderItem

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * Экран обработки заказа менеджером
 *
 * @param navigator для навигации между экранами
 * @param orderedProductsToHandle список продуктов, которые необходимо обработать
 * @param paddingValues отступы от краев экрана
 *
 * @author Michael Gontarev (KiREHwYE)*/
@Destination(style = OrderScreenTransitions::class)
@Composable
fun OrderScreen(
    navigator: DestinationsNavigator,
    orderedProductsToHandle: List<Product> = listOf(
        Product(),Product(),Product(),Product(),Product(),Product(),Product(),Product(),Product(),Product(),Product(),Product(),Product(),Product(),Product(),Product()
    ),
    paddingValues: PaddingValues = PaddingValues(start = 28.dp, end = 28.dp)
) {

    BackHandler {
        navigator.popBackStack()
        return@BackHandler
    }

    ListWithTopAndFab(
        listSize = orderedProductsToHandle.size,
        topBar = {
            TopBar(
                destination = AppDestinations.ManagerDestinations.ORDER,
                navigator = navigator
            )
        },
        floatingButton = { shiftBarDown ->
            OrderFloatingButton(
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectVerticalDragGestures { change, dragAmount ->
                            if (dragAmount > 0) {
                                shiftBarDown()
                            }
                        }
                    },
                onClick = {
                    /*TODO*/
                }
            )
        }
    ) {
        LazyColumn(
            modifier = it,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = 28.dp)
        ) {

            itemsIndexed(
                orderedProductsToHandle,
                key = null
            ) { index, item ->

                OrderItem(
                    name = item.title,
                    price = item.price.toString(),
                    amount = 3.0
                )
            }
        }
    }
}