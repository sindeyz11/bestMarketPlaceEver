package com.kire.market_place_android.presentation.navigation.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelItemsScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.FavouritesScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ManagerScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.OrderScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ProfileScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ShoppingCartScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ShoppingScreenDestination
import com.kire.test.R
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec


sealed interface AppDestinations {
    enum class BottomBarDestinations (
        val direction: DirectionDestinationSpec,
        @DrawableRes val iconTop: Int?,
        @DrawableRes val iconBottom: Int?,
        @StringRes val label: Int,
        @DrawableRes val plusButton: Int?
    ) : AppDestinations {

        SHOPPING(ShoppingScreenDestination, R.drawable.location, R.drawable.shopping_bottom_bar, R.string.home_screen_label, null),
        FAVOURITE(FavouritesScreenDestination, R.drawable.favourite_top_bar, R.drawable.favourite_bottom_bar, R.string.favourite_screen_label, null),
        PROFILE(ProfileScreenDestination, R.drawable.profile_top_bar, R.drawable.profile_bottom_bar, R.string.profile_screen_label, null),
        ADMIN_PANEL(AdminPanelScreenDestination, null, R.drawable.admin_panel_icon, R.string.manager_screen_label, null),
        MANAGER(ManagerScreenDestination, R.drawable.manager_top_bottom_bars, R.drawable.manager_top_bottom_bars, R.string.manager_screen_label, null),
        SHOPPING_CART(ShoppingCartScreenDestination, R.drawable.shopping_cart_top_bar, R.drawable.shopping_cart_bottom_bar, R.string.shopping_cart_screen_label, null)
    }

    enum class AdminDestinations (
        val direction: DirectionDestinationSpec,
        @DrawableRes val iconTop: Int?,
        @DrawableRes val iconBottom: Int?,
        @StringRes val label: Int,
        @DrawableRes val plusButton: Int?
    ) : AppDestinations {

        ADMIN_PANEL_ITEMS(AdminPanelItemsScreenDestination, R.drawable.admin_panel_icon, R.drawable.admin_panel_icon, R.string.pick_up_points, R.drawable.plus_bold)
    }

    enum class ManagerDestinations (
        val direction: DirectionDestinationSpec,
        @DrawableRes val iconTop: Int?,
        @DrawableRes val iconBottom: Int?,
        @StringRes val label: Int,
        @DrawableRes val plusButton: Int?
    ) : AppDestinations {

        ORDER(OrderScreenDestination, R.drawable.arrow_back_top_bar, null, R.string.order_title, null)
    }
}


fun AppDestinations.getDirection() : DirectionDestinationSpec {
    if (this is AppDestinations.BottomBarDestinations)
        return this.direction
    else if (this is AppDestinations.AdminDestinations)
        return this.direction
    else if (this is AppDestinations.ManagerDestinations)
        return this.direction
    return ShoppingScreenDestination
}

fun AppDestinations.getLabel() : Int {
    if (this is AppDestinations.BottomBarDestinations)
        return this.label
    else if (this is AppDestinations.AdminDestinations)
        return this.label
    else if (this is AppDestinations.ManagerDestinations)
        return this.label
    return R.string.home_screen_label
}

fun AppDestinations.getIconTop() : Int? {
    if (this is AppDestinations.BottomBarDestinations)
        return this.iconTop
    else if (this is AppDestinations.AdminDestinations)
        return this.iconTop
    else if (this is AppDestinations.ManagerDestinations)
        return this.iconTop
    return R.drawable.shopping_top_bar
}

fun AppDestinations.getPlusButton() : Int? {
    if (this is AppDestinations.BottomBarDestinations)
        return this.plusButton
    else if (this is AppDestinations.AdminDestinations)
        return this.plusButton
    else if (this is AppDestinations.ManagerDestinations)
        return this.plusButton
    return R.drawable.plus_bold
}



