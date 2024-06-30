package com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight

import androidx.compose.material3.Icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import com.kire.market_place_android.presentation.model.user.Role
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.ui.screen.NavGraphs
import com.kire.market_place_android.presentation.ui.screen.appCurrentDestinationAsState
import com.kire.market_place_android.presentation.ui.screen.destinations.Destination
import com.kire.market_place_android.presentation.ui.screen.startAppDestination

import com.kire.market_place_android.presentation.ui.theme.ExtendedTheme
import com.kire.market_place_android.presentation.util.bounceClick

import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec


/**
 * Основной нижний бар приложения
 *
 * @param role роль пользователя
 * @param navHostController контроллер навигации
 * @param paddingStartEndBottom отступы от краев экрана
 *
 * @author Michael Gontarev (KiREHwYE)*/
@Composable
fun BottomBar(
    role: Role,
    navHostController: NavHostController,
    paddingStartEndBottom: Dp = 28.dp
) {

    val currentDestination: Destination = navHostController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    val appBarsDestinations: List<DirectionDestinationSpec> = AppDestinations.BottomBarDestinations.entries.map { it.direction }

    var permittedList by remember {
        mutableStateOf(emptyList<AppDestinations.BottomBarDestinations>())
    }

    LaunchedEffect(key1 = role) {
        permittedList = when(role) {
            Role.USER ->
                listOf(AppDestinations.BottomBarDestinations.MANAGER, AppDestinations.BottomBarDestinations.ADMIN_PANEL)
            Role.MANAGER ->
                listOf(AppDestinations.BottomBarDestinations.ADMIN_PANEL)
            Role.ADMIN ->
                listOf(AppDestinations.BottomBarDestinations.MANAGER)
        }
    }

    if (appBarsDestinations.contains(currentDestination as DirectionDestinationSpec))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .pointerInput(Unit) {
                    detectTapGestures {
                        //just to make unclickable
                    }
                }
                .background(Color.White)
                .padding(
                    start = paddingStartEndBottom,
                    end = paddingStartEndBottom,
                    top = 18.dp,
                    bottom = 18.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            AppDestinations.BottomBarDestinations.entries.forEach { destination ->

                if (!permittedList.contains(destination))
                    Icon(
                        painter = painterResource(id = destination.iconBottom!!),
                        contentDescription = null,
                        tint =
                        if (currentDestination == destination.direction)
                            ExtendedTheme.colors.redAccent
                        else Color.Black,
                        modifier = Modifier
                            .size(30.dp)
                            .bounceClick {
                                if (currentDestination.route != destination.direction.route)
                                    navHostController.navigate(destination.direction)
                            }
                    )
            }
        }

}
