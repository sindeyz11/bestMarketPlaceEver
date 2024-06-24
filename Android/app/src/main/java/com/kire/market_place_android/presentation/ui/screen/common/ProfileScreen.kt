package com.kire.market_place_android.presentation.ui.screen.common

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

import androidx.activity.compose.BackHandler

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.ExperimentalMaterial3Api
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

import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.kire.market_place_android.presentation.model.user.IUserResult
import com.kire.market_place_android.presentation.navigation.transition.ProfileScreenTransitions
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.screen.profile_screen_ui.ChangePasswordBottomBar
import com.kire.market_place_android.presentation.screen.profile_screen_ui.ProfileDataBottomBar
import com.kire.market_place_android.presentation.ui.details.common_screen.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.ui.details.common_screen.profile_screen_ui.ChangePasswordBar
import com.kire.market_place_android.presentation.ui.details.common_screen.profile_screen_ui.PaymentMethod
import com.kire.market_place_android.presentation.ui.details.common_screen.profile_screen_ui.PurchaseRelatedInfoBar
import com.kire.market_place_android.presentation.ui.details.common_screen.profile_screen_ui.UserProfileInfo
import com.kire.market_place_android.presentation.ui.screen.destinations.DeliveriesScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ShoppingScreenDestination
import com.kire.market_place_android.presentation.viewmodel.UserViewModel

import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * By Michael Gontarev (KiREHwYE)*/
@OptIn(ExperimentalMaterial3Api::class)
@Destination(style = ProfileScreenTransitions::class)
@Composable
fun ProfileScreen(
    userViewModel: UserViewModel,
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues = PaddingValues(start = 28.dp, end = 28.dp, bottom = 66.dp)
) {

    BackHandler {
        navigator.popBackStack(ShoppingScreenDestination, inclusive = false)
        return@BackHandler
    }

    val context = LocalContext.current

    val userResult by userViewModel.userResult.collectAsStateWithLifecycle()
    val profileState = userViewModel.profileState

//    LaunchedEffect(userViewModel, context) {
//        userViewModel.updateUser()
//    }

    LaunchedEffect(userResult) {
        if (userResult is IUserResult.SuccessfullyChanged)
            Toast.makeText(
                context,
                context.getText(R.string.successfully_changed),
                LENGTH_SHORT
            ).show()
        if (userResult is IUserResult.Error)
            Toast.makeText(
                context,
                if ((userResult as IUserResult.Error).message?.isNotEmpty() == true)
                    (userResult as IUserResult.Error).message
                else context.getText(R.string.some_error),
                LENGTH_SHORT
            ).show()
    }

    val scrollState = rememberScrollState()
    val sheetState = rememberModalBottomSheetState()

    var showChangePasswordBottomBar by remember {
        mutableStateOf(false)
    }
    var showProfileDataBottomBar by remember {
        mutableStateOf(false)
    }

    profileState.apply {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopBar(
                logOut = userViewModel::logOut,
                destination = AppDestinations.BottomBarDestinations.PROFILE,
                navigator = navigator
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .heightIn(max = 1000.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                UserProfileInfo(
                    name = username,
                    phone = phone,
                    email = email,
                    showBottomSheet = { show ->
                        showProfileDataBottomBar = show
                    }
                )

                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    columns = GridCells.Fixed(count = 2),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    item {
                        PurchaseRelatedInfoBar(
                            title = stringResource(id = R.string.total_purchases_title),
                            sign = stringResource(id = R.string.rub),
                            info = amountSpent?.toString() ?: 0.toString()
                        )
                    }

                    item {
                        PurchaseRelatedInfoBar(
                            title = stringResource(id = R.string.total_purchases_percent_title),
                            sign = stringResource(id = R.string.percent),
                            info =
                                if (redemptionPercent?.isNaN() == true)
                                    0.0.toString()
                                else redemptionPercent?.toString() ?: 0.0.toString()
                        )
                    }

                    item {
                        PurchaseRelatedInfoBar(
                            title = stringResource(id = R.string.discount_title),
                            sign = stringResource(id = R.string.percent),
                            info = userDiscount?.toString() ?: 0.0.toString()
                        )
                    }

                    item {
                        PurchaseRelatedInfoBar(
                            title = stringResource(id = R.string.deliveries_title),
                            sign =
//                        if (profileUiState.nextDeliveryDate == null)
//                            ""
//                        else
//                            profileUiState.nextDeliveryDate.day.toString(),
                            "",
                            info =
//                        if (profileUiState.nextDeliveryDate == null)
                            stringResource(id = R.string.no_deliveries_info),
//                        else
//                            (profileUiState.nextDeliveryDate.month + 1).toString(),
                            onClick = {
                                navigator.navigate(DeliveriesScreenDestination)
                            }
                        )
                    }
                }

                PaymentMethod(
                    profileState = profileState,
                    onEvent = userViewModel::onEvent
                )

                ChangePasswordBar(
                    onClick = { show ->
                        showChangePasswordBottomBar = show
                    }
                )
            }

        }
    }


    if (showChangePasswordBottomBar)
        ChangePasswordBottomBar(
            sheetState = sheetState,
            profileState = profileState,
            onEvent = userViewModel::onEvent,
            showBottomSheet = { show ->
                showChangePasswordBottomBar = show
            },
        )


    if (showProfileDataBottomBar)
        ProfileDataBottomBar(
            profileState = profileState,
            onEvent = userViewModel::onEvent,
            sheetState = sheetState,
            showBottomSheet = { show ->
                showProfileDataBottomBar = show
            }
        )
}