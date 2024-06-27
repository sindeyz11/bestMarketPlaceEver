package com.kire.market_place_android.presentation.ui.screen.admin

import android.widget.Toast

import androidx.activity.compose.BackHandler

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.kire.market_place_android.presentation.model.admin.AdminUiEvent
import com.kire.market_place_android.presentation.model.admin.IAdminResult
import com.kire.market_place_android.presentation.navigation.transition.admin.AdminPanelPickUpScreenTransitions
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.screen.admin_panel_pick_up_screen_ui.PickUpPointBottomBar
import com.kire.market_place_android.presentation.ui.details.admin.admin_panel_pick_up_screen_ui.AdminPickUpCard
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.ListWithTopAndFab
import com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.viewmodel.AdminViewModel

import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * Список всех пунктов выдачи
 *
 * @param adminViewModel ViewModel админа
 * @param horizontalPaddingValues горизонтальные отступы от краев экрана
 * @param navigator для навигации между экранами
 *
 * @author Michael Gontarev (KiREHwYE)
 * @author Aleksey Timko (de4ltt)*/
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

    val sheetState = rememberModalBottomSheetState()

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

    ListWithTopAndFab(
        listSize = allPickUpPoints.size,
        topBar = {
            TopBar(
                destination = AppDestinations.AdminDestinations.ADMIN_PANEL_PICK_UP,
                onPlusClick = {
                    adminViewModel.onEvent(AdminUiEvent.ChangeIsCreateBottomBarExpanded(true))
                }
            )
        }
    ) {

        LazyColumn(
            modifier = it,
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

    if (adminState.isCreateBottomBarExpanded || adminState.isUpdateBottomBarExpanded)
        PickUpPointBottomBar(
            adminState = adminState,
            sheetState = sheetState,
            onEvent = adminViewModel::onEvent
        )
}