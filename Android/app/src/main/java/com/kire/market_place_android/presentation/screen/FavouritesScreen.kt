package com.kire.market_place_android.presentation.screen

import androidx.activity.compose.BackHandler

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import com.kire.market_place_android.presentation.navigation.Transition.FavouritesScreenTransitions
import com.kire.market_place_android.presentation.screen.destinations.FavouritesScreenDestination

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(style = FavouritesScreenTransitions::class)
@Composable
fun FavouritesScreen(
    navigator: DestinationsNavigator
) {

    BackHandler {
        navigator.popBackStack(FavouritesScreenDestination, inclusive = true)
        return@BackHandler
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

    }
}
