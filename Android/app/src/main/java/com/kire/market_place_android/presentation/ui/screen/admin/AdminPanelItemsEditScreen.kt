package com.kire.market_place_android.presentation.ui.screen.admin

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kire.market_place_android.presentation.model.product.Product
import com.kire.market_place_android.presentation.navigation.transition.AdminPanelItemsEditScreenTransitions
import com.kire.market_place_android.presentation.ui.details.admin.admin_panel_items_edit_screen_ui.AdminEditTopControls
import com.kire.market_place_android.presentation.ui.details.admin.admin_panel_items_edit_screen_ui.AdminPanelIconField
import com.kire.market_place_android.presentation.ui.details.common_screen.item_add_to_cart_menu_ui.BottomButtonFinishOperation
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelItemsEditScreenDestination
import com.kire.market_place_android.presentation.viewmodel.AdminViewModel
import com.kire.test.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * By Michael Gontarev (KiREHwYE)
 * By Aleksey Timko (de4ltt)*/
@Destination(style = AdminPanelItemsEditScreenTransitions::class)
@Composable
fun AdminPanelItemsEditScreen(
    adminViewModel: AdminViewModel,
    product: Product = Product(),
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues = PaddingValues(28.dp)
) {
    BackHandler {
        navigator.popBackStack()
        return@BackHandler
    }

    val scrollState = rememberScrollState()

    product.apply {
        //TODO

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .pointerInput(Unit) {
                    detectVerticalDragGestures { _, dragAmount ->

                        val y = dragAmount

                        if (y > 60) {
                            navigator.popBackStack(
                                AdminPanelItemsEditScreenDestination,
                                inclusive = true
                            )
                        }
                    }
                },
            verticalArrangement = Arrangement.spacedBy((-24).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //ImageRequest should be replaced with URI
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.item_menu_default)
                    .build(),
                placeholder = painterResource(id = R.drawable.item_menu_default),
                contentDescription = "Shopping cart item image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 1.1f)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        Color.White,
                        RoundedCornerShape(
                            topStart = 24.dp,
                            topEnd = 24.dp
                        )
                    )
                    .padding(paddingValues)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 1000.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AdminPanelIconField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            icon = R.drawable.name_icon,
                            hintText = R.string.enter_name
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
                                AdminPanelIconField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp),
                                    icon = R.drawable.rub,
                                    hintText = R.string.rub_num,
                                    isTextCentered = true
                                )
                            }
                            item {
                                AdminPanelIconField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp),
                                    icon = R.drawable.scale,
                                    hintText = R.string.scale,
                                    isTextCentered = true
                                )
                            }

                            item {
                                AdminPanelIconField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp),
                                    icon = R.drawable.rub_proc,
                                    hintText = R.string.rub_num,
                                    isTextCentered = true
                                )
                            }

                            item {
                                AdminPanelIconField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp),
                                    icon = R.drawable.container,
                                    hintText = R.string.contains,
                                    isTextCentered = true
                                )
                            }
                        }

                        AdminPanelIconField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp),
                            icon = null,
                            hintText = R.string.description,
                            isTextCentered = false
                        )
                    }
                }

                BottomButtonFinishOperation(
                    textValue = stringResource(id = R.string.save),
                    onClick = {  /* TODO */ }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopStart
        ) {
            AdminEditTopControls(
                onArrowBackClick = {
                    navigator.popBackStack()
                },
                rightButton = {
                    Icon(
                        painter = painterResource(id = R.drawable.update_sign),
                        contentDescription = "update_sign",
                        modifier = Modifier
                            .size(24.dp)
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    /*TODO()*/
                                }
                            },
                        tint = Color.Black
                    )
                }
            )
        }
    }
}
