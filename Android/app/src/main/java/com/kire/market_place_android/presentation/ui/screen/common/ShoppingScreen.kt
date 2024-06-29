package com.kire.market_place_android.presentation.ui.screen.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.kire.market_place_android.presentation.navigation.transition.common.ShoppingScreenTransitions

import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.screen.shopping_screen_ui.ItemCard
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.ListWithTopAndFab
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.RequestResultMessage
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.ui.details.common.shopping_screen_ui.FilterBottomBar
import com.kire.market_place_android.presentation.ui.details.common.shopping_screen_ui.ShoppingScreenSearchBar
import com.kire.market_place_android.presentation.ui.screen.destinations.ItemAddToCartMenuDestination
import com.kire.market_place_android.presentation.viewmodel.ProductViewModel

import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * Основной экран магазина со списком товаров
 *
 * @param productViewModel ViewModel для работы с товарами
 * @param navigator для навигации между экранами
 * @param paddingValues отступы от краёв экрана
 *
 * @author Michael Gontarev (KiREHwYE)
 * @author Aleksey Timko (de4ltt)*/
@OptIn(ExperimentalMaterial3Api::class)
@Destination(style = ShoppingScreenTransitions::class)
@Composable
fun ShoppingScreen(
    productViewModel: ProductViewModel,
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues = PaddingValues(start = 28.dp, end = 28.dp, bottom = 66.dp)
) {

    val allProducts by productViewModel.allProducts.collectAsStateWithLifecycle()
    val allCategories by productViewModel.allCategories.collectAsStateWithLifecycle()

    val requestResult by productViewModel.requestResult.collectAsStateWithLifecycle()

    RequestResultMessage(requestResult = requestResult)

    val plusIcon = R.drawable.plus

    var isFilterShown by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState()

    ListWithTopAndFab(
        listSize = allProducts.size,
        topBar = {
            TopBar(
                destination = AppDestinations.BottomBarDestinations.SHOPPING,
                searchBar = {
                    ShoppingScreenSearchBar(
                        curSearchRequest = null,
                        showFilter = {
                            isFilterShown = it
                        }
                    )
                }
            )
        }
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = it
        ) {
            items(
                allProducts,
//                key = {it.id}
            ) { product ->
                ItemCard(
                    product = product,
                    onButtonClick = {
                        /*TODO()*/
                    },
                    buttonIcon = plusIcon,
                    onClick = {
                        productViewModel.chooseProduct(product)
                        navigator.navigate(ItemAddToCartMenuDestination)
                    }
                )
            }
        }
    }


    if (isFilterShown)
        FilterBottomBar(
            allCategories = allCategories,
            showBottomSheet = {
                isFilterShown = it
            },
            sheetState = sheetState
        )
}
