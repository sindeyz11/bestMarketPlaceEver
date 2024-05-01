package com.kire.market_place_android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.kire.market_place_android.presentation.ui.screen.AdminPanelItemsEditScreen
import com.kire.market_place_android.presentation.ui.screen.AdminPanelItemsScreen
import com.kire.market_place_android.presentation.ui.screen.AdminPanelScreen
import com.kire.market_place_android.presentation.ui.screen.FavouritesScreen
import com.kire.market_place_android.presentation.ui.screen.ItemAddToCartMenu
import com.kire.market_place_android.presentation.ui.screen.LogInScreen
import com.kire.market_place_android.presentation.ui.screen.LogOnScreen
import com.kire.market_place_android.presentation.ui.screen.ManagerScreen
import com.kire.market_place_android.presentation.ui.screen.NavGraphs
import com.kire.market_place_android.presentation.ui.screen.OrderScreen
import com.kire.market_place_android.presentation.ui.screen.ProfileScreen
import com.kire.market_place_android.presentation.ui.screen.ShoppingScreen
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelItemsEditScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelItemsScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.FavouritesScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ItemAddToCartMenuDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.LogInScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.LogOnScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ManagerScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.OrderScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ProfileScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ShoppingScreenDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.spec.NavHostEngine

@Composable
fun NavigationUI(
    navHostController: NavHostController,
    navHostEngine: NavHostEngine
){

    DestinationsNavHost(
        navGraph = NavGraphs.root,
        engine = navHostEngine,
        navController = navHostController
    ) {

        composable(FavouritesScreenDestination) {
            FavouritesScreen(
                navigator = destinationsNavigator
            )
        }
        composable(ItemAddToCartMenuDestination) {
            ItemAddToCartMenu(
                navigator = destinationsNavigator
            )
        }
        composable(LogInScreenDestination) {
            LogInScreen(
                navigator = destinationsNavigator
            )
        }
        composable(LogOnScreenDestination) {
            LogOnScreen(
                navigator = destinationsNavigator
            )
        }
        composable(AdminPanelScreenDestination) {
            AdminPanelScreen(
                navigator = destinationsNavigator
            )
        }
        composable(AdminPanelItemsScreenDestination) {
            AdminPanelItemsScreen(
                navigator = destinationsNavigator
            )
        }
        composable(AdminPanelItemsEditScreenDestination) {
            AdminPanelItemsEditScreen(
                navigator = destinationsNavigator
            )
        }
        composable(ProfileScreenDestination) {
            ProfileScreen(
                navigator = destinationsNavigator
            )
        }
        composable(ManagerScreenDestination) {
            ManagerScreen(
                navigator = destinationsNavigator
            )
        }
        composable(ShoppingScreenDestination) {
            ShoppingScreen(
                navigator = destinationsNavigator
            )
        }
        composable(OrderScreenDestination) {
            OrderScreen(
                navigator = destinationsNavigator
            )
        }
    }
}
