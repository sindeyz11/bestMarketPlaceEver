package com.kire.market_place_android.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.kire.market_place_android.presentation.model.ProfileScreenUiState
import com.kire.market_place_android.presentation.navigation.Transition.ProfileScreenTransitions
import com.kire.market_place_android.presentation.screen.profile_screen_ui.ChangePasswordBar
import com.kire.market_place_android.presentation.screen.profile_screen_ui.PurchaseRelatedInfo
import com.kire.market_place_android.presentation.screen.profile_screen_ui.UserProfileInfo
import com.kire.market_place_android.presentation.screen.profile_screen_ui.PaymentMethod

import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination

@Destination(style = ProfileScreenTransitions::class)
@Composable
fun ProfileScreen(
    profileUiState: ProfileScreenUiState =
        ProfileScreenUiState(
            name = "Kire",
            phone = "8 900 000 00-00",
            email = "email@gmail.com",
            totalPurchases = 47250.00,
            totalPurchasesPercent = 68.12,
            discount = 5.88,
            nextDeliveryDate = null
        ),
    paddingValues: PaddingValues = PaddingValues(28.dp)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        UserProfileInfo(
            name = profileUiState.name,
            phone = profileUiState.phone,
            email = profileUiState.email
        )

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            columns = GridCells.Fixed(count = 2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            item {
                PurchaseRelatedInfo(
                    title = stringResource(id = R.string.total_purchases_title),
                    sign = stringResource(id = R.string.rub),
                    info = profileUiState.totalPurchases.toString()
                )
            }

            item {
                PurchaseRelatedInfo(
                    title = stringResource(id = R.string.total_purchases_percent_title),
                    sign = stringResource(id = R.string.percent),
                    info = profileUiState.totalPurchasesPercent.toString()
                )
            }

            item {
                PurchaseRelatedInfo(
                    title = stringResource(id = R.string.discount_title),
                    sign = stringResource(id = R.string.percent),
                    info = profileUiState.discount.toString()
                )
            }

            item {
                PurchaseRelatedInfo(
                    title = stringResource(id = R.string.deliveries_title),
                    sign = if (profileUiState.nextDeliveryDate == null)
                        ""
                    else
                        profileUiState.nextDeliveryDate.day.toString(),
                    info =
                    if (profileUiState.nextDeliveryDate == null)
                        stringResource(id = R.string.no_deliveries_info)
                    else
                        (profileUiState.nextDeliveryDate.month + 1).toString(),
                    onClick = {
                        /*TODO*/
                    }
                )
            }
        }

        PaymentMethod(
            creditCard = profileUiState.creditCard
        )

        ChangePasswordBar(
            onClick = {
                /*TODO()*/
            }
        )
    }
}