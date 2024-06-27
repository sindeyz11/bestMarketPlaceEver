package com.kire.market_place_android.presentation.ui.screen.admin

import androidx.activity.compose.BackHandler

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


import com.kire.market_place_android.presentation.model.product.Product
import com.kire.market_place_android.presentation.navigation.transition.admin.AdminPanelItemsScreenTransitions
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.screen.shopping_screen_ui.ItemCard
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.ListWithTopAndFab
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelItemsEditScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ItemAddToCartMenuDestination
import com.kire.market_place_android.presentation.viewmodel.AdminViewModel

import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * Список всех позиций, представленных в KubMarket
 *
 * @param adminViewModel ViewModel админа
 * @param navigator для навигации между экранами
 * @param paddingValues отступы от краев экрана
 *
 * @author Michael Gontarev (KiREHwYE)
 * @author Aleksey Timko (de4ltt)*/
@Destination(style = AdminPanelItemsScreenTransitions::class)
@Composable
fun AdminPanelItemsScreen(
    adminViewModel: AdminViewModel,
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues = PaddingValues(start = 28.dp, end = 28.dp)
) {

    BackHandler {
        navigator.popBackStack()
        return@BackHandler
    }

    val itemsList: List<Product> = listOf(
        Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product(), Product()
    )

    val editIcon = R.drawable.edit_profile_info

    ListWithTopAndFab(
        listSize = itemsList.size,
        topBar = {
            TopBar(
                destination = AppDestinations.AdminDestinations.ADMIN_PANEL_ITEMS,
                onPlusClick = {
                    navigator.navigate(AdminPanelItemsEditScreenDestination)
                }
            )
        }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(bottom = 28.dp),
            modifier = it
        ) {
            items(itemsList) { item ->
                ItemCard(
                    product = item,
                    onClick = { navigator.navigate(ItemAddToCartMenuDestination) },
                    onButtonClick = { navigator.navigate(AdminPanelItemsEditScreenDestination) },
                    buttonIcon = editIcon
                )
            }
        }
    }
}