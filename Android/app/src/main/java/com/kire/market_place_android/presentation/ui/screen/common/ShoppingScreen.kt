package com.kire.market_place_android.presentation.ui.screen.common

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.kire.market_place_android.presentation.model.product.IProductResult
import com.kire.market_place_android.presentation.navigation.transition.ShoppingScreenTransitions

import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.screen.shopping_screen_ui.ItemCard
import com.kire.market_place_android.presentation.ui.details.common_screen.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.ui.details.common_screen.shopping_screen_ui.FilterBottomBar
import com.kire.market_place_android.presentation.ui.details.common_screen.shopping_screen_ui.ShoppingScreenSearchBar
import com.kire.market_place_android.presentation.ui.screen.destinations.ItemAddToCartMenuDestination
import com.kire.market_place_android.presentation.viewmodel.ProductViewModel

import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


/**
 * By Aleksey Timko (de4ltt)
 * By Michael Gontarev (KiREHwYe)*/
@OptIn(ExperimentalMaterial3Api::class)
@Destination(style = ShoppingScreenTransitions::class)
@Composable
fun ShoppingScreen(
    productViewModel: ProductViewModel,
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues = PaddingValues(start = 28.dp, end = 28.dp, bottom = 66.dp)
) {

    val context = LocalContext.current

    val allProducts by productViewModel.allProducts.collectAsStateWithLifecycle()
    val allCategories by productViewModel.allCategories.collectAsStateWithLifecycle()

    val productResult by productViewModel.productResult.collectAsStateWithLifecycle()

    LaunchedEffect(productResult) {
        if (productResult is IProductResult.Error)
            Toast.makeText(
                context,
                if ((productResult as IProductResult.Error).message?.isNotEmpty() == true)
                        (productResult as IProductResult.Error).message
                else context.getText(R.string.some_error),
                Toast.LENGTH_SHORT
            ).show()
    }

    val plusIcon = R.drawable.plus

    var isFilterShown by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues = paddingValues),
        verticalArrangement = Arrangement.spacedBy(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBar(
            destination = AppDestinations.BottomBarDestinations.SHOPPING
        )

        ShoppingScreenSearchBar(
            curSearchRequest = null,
            showFilter = {
                isFilterShown = it
            }
        )

        when (allProducts.size) {
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
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(allProducts, key = {it.id}) { product ->
                        ItemCard(
                            product = product,
                            onButtonClick = {
                                /*TODO()*/
                            },
                            buttonIcon = plusIcon,
                            onClick = {
                                navigator.navigate(ItemAddToCartMenuDestination)
                            }
                        )
                    }
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
}
