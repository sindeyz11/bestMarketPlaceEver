package com.kire.market_place_android.presentation.ui.screen.admin

import android.widget.Toast

import androidx.activity.compose.BackHandler

import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.kire.market_place_android.presentation.model.admin.IAdminResult
import com.kire.market_place_android.presentation.navigation.transition.AdminPanelUsersScreenTransitions
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.screen.admin_panel_users_screen_ui.AdminUserBar
import com.kire.market_place_android.presentation.ui.details.common_screen.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.viewmodel.AdminViewModel
import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * By Aleksey Timko (de4ltt)*/
@Destination(style = AdminPanelUsersScreenTransitions::class)
@Composable
fun AdminPanelUsersScreen(
    adminViewModel: AdminViewModel,
    horizontalPaddingValues: PaddingValues = PaddingValues(horizontal = 28.dp),
    navigator: DestinationsNavigator
) {

    BackHandler {
        navigator.popBackStack()
        return@BackHandler
    }

    val context = LocalContext.current

    val allUsers by adminViewModel.allUsers.collectAsStateWithLifecycle()

    val adminResult by adminViewModel.adminResult.collectAsStateWithLifecycle()

    LaunchedEffect(adminResult) {
        if (adminResult is IAdminResult.Error)
            Toast.makeText(
                context,
                if ((adminResult as IAdminResult.Error).message?.isNotEmpty() == true)
                    (adminResult as IAdminResult.Error).message
                else context.getText(R.string.some_error),
                Toast.LENGTH_SHORT
            ).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontalPaddingValues),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBar(destination = AppDestinations.AdminDestinations.ADMIN_PANEL_USERS)

        Spacer(modifier = Modifier.height(16.dp))

        when (allUsers.size) {
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

                    items(allUsers) { user ->
                        AdminUserBar(user = user)
                    }
                }
            }
        }
    }
}