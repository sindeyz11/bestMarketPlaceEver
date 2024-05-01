package com.kire.market_place_android.presentation.screen

import androidx.activity.compose.BackHandler

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.kire.market_place_android.presentation.navigation.Transition.ManagerScreenTransitions
import com.kire.market_place_android.presentation.screen.destinations.ManagerScreenDestination
import com.kire.market_place_android.presentation.screen.manager_screen_ui.OrderReleasingBar
import com.kire.market_place_android.presentation.screen.manager_screen_ui.PickUpPointIncomeBar
import com.kire.market_place_android.presentation.screen.manager_screen_ui.PickUpPointInfoBar

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(style = ManagerScreenTransitions::class)
@Composable
fun ManagerScreen(
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues = PaddingValues(28.dp)
){

    BackHandler {
        navigator.popBackStack(ManagerScreenDestination, inclusive = true)
        return@BackHandler
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OrderReleasingBar(
            onClick = {
                /*TODO()*/
            }
        )

        PickUpPointInfoBar(
            pickUpPointAddress = "г. Краснодар, ул. Ставропольская, 149",
            pickUpPointCode = "КРД-0001",
            pickUpPointManager = "Бобр"
        )

        PickUpPointIncomeBar(
            income = 47250.00
        )
    }
}