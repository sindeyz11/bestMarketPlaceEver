package com.kire.market_place_android.presentation.ui.screen.admin

import android.widget.Toast

import androidx.activity.compose.BackHandler

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.kire.market_place_android.presentation.model.admin.AdminUiEvent
import com.kire.market_place_android.presentation.model.admin.IAdminResult
import com.kire.market_place_android.presentation.navigation.transition.AdminPanelPickUpScreenTransitions
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.screen.admin_panel_pick_up_screen_ui.PickUpPointBottomBar
import com.kire.market_place_android.presentation.ui.details.admin.admin_panel_pick_up_screen_ui.AdminPickUpCard
import com.kire.market_place_android.presentation.ui.details.common_screen.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.viewmodel.AdminViewModel

import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * By Aleksey Timko (de4ltt)*/
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Destination(style = AdminPanelPickUpScreenTransitions::class)
@Composable
fun AdminPanelPickUpScreen(
    adminViewModel: AdminViewModel,
    horizontalPaddingValues: PaddingValues = PaddingValues(horizontal = 28.dp),
    navigator: DestinationsNavigator
) {
    BackHandler {
        navigator.popBackStack()
        return@BackHandler
    }

    val context = LocalContext.current

    val allPickUpPoints by adminViewModel.allPickUpPoints.collectAsStateWithLifecycle()

    val adminState = adminViewModel.adminState

    val adminResult by adminViewModel.adminResult.collectAsStateWithLifecycle()

    LaunchedEffect(adminResult) {
        when(adminResult) {
            is IAdminResult.Error -> {
                Toast.makeText(
                    context,
                    if ((adminResult as IAdminResult.Error).message?.isNotEmpty() == true)
                        (adminResult as IAdminResult.Error).message
                    else context.getText(R.string.some_error),
                    Toast.LENGTH_SHORT
                ).show()
            }
            IAdminResult.SuccessfullyDone -> {
                Toast.makeText(
                    context,
                    context.getText(R.string.success),
                    Toast.LENGTH_SHORT
                ).show()
                adminViewModel.getAllPickUpPoints()
            }
            else -> {

            }
        }
    }

    val sheetState = rememberModalBottomSheetState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    adminViewModel.onEvent(AdminUiEvent.ChangeOnDismissRequest(true))
                }
            }
            .background(Color.White)
            .padding(horizontalPaddingValues),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBar(
            destination = AppDestinations.AdminDestinations.ADMIN_PANEL_PICK_UP,
            onClick = {
                adminViewModel.onEvent(AdminUiEvent.ChangeIsCreateBottomBarExpanded(true))
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        when (allPickUpPoints.size) {
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
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    contentPadding = PaddingValues(bottom = 28.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    items(allPickUpPoints, key = {it.id}) { pickUpPoint ->
                        AdminPickUpCard(
                            adminState = adminState,
                            pickUpPoint = pickUpPoint,
                            onEvent = adminViewModel::onEvent,
                            modifier = Modifier.animateItemPlacement(
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = LinearOutSlowInEasing
                                )
                            )
                        )
                    }
                }
            }
        }
    }

    if (adminState.isCreateBottomBarExpanded || adminState.isUpdateBottomBarExpanded)
        PickUpPointBottomBar(
            adminState = adminState,
            sheetState = sheetState,
            onEvent = adminViewModel::onEvent
        )
}