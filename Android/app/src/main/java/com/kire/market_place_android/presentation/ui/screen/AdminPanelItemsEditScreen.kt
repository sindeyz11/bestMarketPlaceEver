package com.kire.market_place_android.presentation.ui.screen

import android.net.Uri
import androidx.compose.runtime.Composable
import com.kire.market_place_android.presentation.model.ProductItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AdminPanelItemsEditScreen(
    productItem: ProductItem = ProductItem(
        1, "Помидоры", 250.00,
        "кг", 250.00,
        Uri.EMPTY, false,
        "Помогите, они украли мою семью..."
    ),
    navigator: DestinationsNavigator
) {
    /*productItem.apply {
        //TODO
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(430.dp),
            content = {
                AsyncImage(
                    model = Bitmap.createBitmap(500, 430, Bitmap.Config.RGB_565),
                    *//*placeholder = painterResource(id = R.drawable.item_menu_default) ,*//*
                    contentDescription = "Item Cart Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(430.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = 45.dp,
                            start = 20.dp,
                            end = 20.dp,
                            bottom = 25.dp
                        ),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .size(55.dp)
                                .background(
                                    Color.White,
                                    RoundedCornerShape(30.dp)
                                ),
                            contentAlignment = Alignment.Center,
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_back),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(27.dp)
                                        .clickable(
                                            indication = null,
                                            interactionSource = remember { MutableInteractionSource() },
                                            onClick = { navigator.popBackStack() }
                                        ),
                                    tint = Color.Black
                                )
                            }
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.update_sign),
                            contentDescription = "update_sign"
                        )
                    }
                }


            }
        )

        Column(
            modifier = Modifier
                .padding(top = 415.dp)
                .fillMaxSize()
                .background(
                    Color.White,
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp
                    )
                ),
            content = {

                Column(
                    modifier = Modifier
                        .padding(15.dp)
                ) {
                    AdminPanelIconField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        icon = R.drawable.name_icon,
                        hintText = R.string.enter_name
                    )
                }

                Spacer(modifier = Modifier.size(15.dp))

                BottomButtonFinishOperation(
                    textValue = stringResource(id = R.string.save),
                    onClick = { *//* TODO *//* }
                )

                Spacer(modifier = Modifier.size(15.dp))

            }
        )
    }*/
}