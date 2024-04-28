package com.kire.market_place_android.presentation.screen

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kire.market_place_android.presentation.models.FilterRequest
import com.kire.market_place_android.presentation.models.ProductItem
import com.kire.market_place_android.presentation.screen.shopping_screen_ui.ItemCard
import com.kire.market_place_android.presentation.screen.shopping_screen_ui.ShoppingScreenSearchBar
import com.kire.test.R
import com.ramcosta.composedestinations.annotation.Destination


/**
 * By Aleksey Timko (de4ltt) 28.04.24*/
@Destination(start = true)
@Composable
fun ShoppingScreen(
    curPickUpPoint: String = "г. Краснодар, ул. Ставропольская, 149"
) {
    val itemsLists: List<ProductItem> = listOf(
        ProductItem("Помидоры", "250.00", "кг","250.00", Uri.EMPTY, false),
        ProductItem("Груши", "300.00","кг","250.00", Uri.EMPTY, true),
        ProductItem("Помидоры", "250.00","кг","300.00", Uri.EMPTY, true),
        ProductItem("Груши", "300.00","кг","250.00",Uri.EMPTY, false),
        ProductItem("Помидоры", "250.00","кг","250.00", Uri.EMPTY, false),
        ProductItem("Груши", "300.00","кг","250.00", Uri.EMPTY, true)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 15.dp,
                top = 60.dp,
                end = 15.dp,
                bottom = 0.dp
            ),
        content = {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "Location Icon",
                        tint = Color.Black
                    )

                    Text(
                        modifier = Modifier.padding(end = 5.dp),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 15.5.sp
                                )
                            ) {
                                append(stringResource(id = R.string.pick_up_point))
                            }
                            append("\n")
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.5.sp
                                )
                            ) {
                                append(curPickUpPoint)
                            }
                        },
                        lineHeight = 18.sp
                    )
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(horizontal = 5.dp),
                content = {
                    ShoppingScreenSearchBar(
                        curSearchRequest = null,
                        curFilterRequest = FilterRequest(null, null, null)
                    )
                }
            )

            Spacer(modifier = Modifier.height(5.dp))

            when(itemsLists.size) {
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
                else -> LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                        .fillMaxSize()
                ) {
                    items(itemsLists) { item ->
                        ItemCard(productItem = item)
                    }
                }
            }
        }
    )
}
