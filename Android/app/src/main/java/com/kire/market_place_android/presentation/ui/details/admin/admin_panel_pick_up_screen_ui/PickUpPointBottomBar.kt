package com.kire.market_place_android.presentation.screen.admin_panel_pick_up_screen_ui

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kire.market_place_android.presentation.model.admin.AdminState
import com.kire.market_place_android.presentation.model.admin.AdminUiEvent
import com.kire.market_place_android.presentation.ui.theme.ExtendedTheme
import com.kire.market_place_android.presentation.util.Validator
import com.kire.test.R

/**
 * By Aleksey Timko (de4ltt)*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickUpPointBottomBar(
    adminState: AdminState,
    sheetState: SheetState,
    onEvent: (AdminUiEvent) -> Unit
) {

    val context = LocalContext.current

    ModalBottomSheet(
        onDismissRequest = {
            onEvent(AdminUiEvent.ChangeIsCreateBottomBarExpanded(false))
            onEvent(AdminUiEvent.ChangeIsUpdateBottomBarExpanded(false, pickUpPointToUpdateId = "", address = ""))
        },
        containerColor = Color.White,
        sheetState = sheetState,
        dragHandle = {
            Text(
                text = stringResource(id = R.string.pick_up_point),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 28.dp)
            )
        },
        modifier = Modifier
            .height(IntrinsicSize.Max)
    ) {

        Box(
            modifier = Modifier
                .wrapContentHeight()
                .padding(
                    top = 28.dp,
                    start = 36.dp,
                    end = 36.dp,
                    bottom = 28.dp
                ),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .wrapContentSize(),
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {

                    BasicTextField(
                        modifier = Modifier
                            .height(86.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(ExtendedTheme.colors.profileBar)
                            .padding(16.dp),
                        value = adminState.bottomBarAddress,
                        onValueChange = {
                            onEvent(AdminUiEvent.bottomBarAddressChanged(it))
                        },

                        textStyle = LocalTextStyle.current.copy(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                        ),
                        decorationBox = { innerTextField ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.house),
                                    contentDescription = null,
                                    tint = ExtendedTheme.colors.redAccent,
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                                Box {
                                    if (adminState.bottomBarAddress.isEmpty())
                                        Text(
                                            text = stringResource(id = R.string.adress),
                                            fontWeight = FontWeight.W400,
                                            color = Color.Gray
                                        )
                                    innerTextField()
                                }
                            }
                        }
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.manager_id),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        BasicTextField(
                            modifier = Modifier
                                .height(56.dp)
                                .width(110.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(ExtendedTheme.colors.profileBar)
                                .padding(16.dp),
                            value = adminState.bottomBarManagerId,
                            onValueChange = {
                                onEvent(AdminUiEvent.bottomBarManagerIdChanged(it))
                            },
                            textStyle = LocalTextStyle.current.copy(
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                textAlign = TextAlign.Center
                            ),
                            decorationBox = { innerTextField ->
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    innerTextField()
                                    if (adminState.bottomBarManagerId.isEmpty())
                                        Text(
                                            modifier = Modifier.fillMaxHeight(),
                                            text = stringResource(id = R.string.xxx),
                                            fontWeight = FontWeight.W400,
                                            color = Color.Gray
                                        )
                                }

                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                                try {
                                    Validator.validateManagerId(adminState.bottomBarManagerId)
                                    Validator.validatePickUpPointAddress(adminState.bottomBarAddress)

                                    if (adminState.isCreateBottomBarExpanded)
                                        onEvent(
                                            AdminUiEvent.CreatePickUpPoint(
                                                managerId = adminState.bottomBarManagerId.toInt(),
                                                address = adminState.bottomBarAddress
                                            )
                                        )
                                    else {
                                        Validator.validatePickUpPointToUpdateId(adminState.pickUpPointToUpdateId)
                                        onEvent(
                                            AdminUiEvent.UpdatePickUpPoint(
                                                pickUpPointToUpdateId = adminState.pickUpPointToUpdateId.toInt(),
                                                managerId = adminState.bottomBarManagerId.toInt(),
                                                address = adminState.bottomBarAddress
                                            )
                                        )
                                    }
                                } catch (e: IllegalArgumentException) {
                                    Toast.makeText(context, e.message, LENGTH_SHORT).show()
                                }
                        },
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ExtendedTheme.colors.redAccent
                        )
                    ) {
                        Text(
                            text =
                                if (adminState.isCreateBottomBarExpanded)
                                    stringResource(id = R.string.create_pick_up_point)
                                else
                                    stringResource(id = R.string.update_pick_up_point),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}