package com.kire.market_place_android.presentation.screen.shopping_screen_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kire.market_place_android.presentation.models.FilterRequest
import com.kire.market_place_android.presentation.screen.ShoppingScreen
import com.kire.market_place_android.presentation.theme.OurRed
import com.kire.test.R

/**
 * By Aleksey Timko (de4ltt) 28.04.24*/
@Composable
fun ShoppingScreenSearchBar(
    curSearchRequest: String?,
    curFilterRequest: FilterRequest
) {
    var _curSearchRequest by remember {
        mutableStateOf(curSearchRequest)
    }

    BasicTextField(
        value = _curSearchRequest ?: stringResource(id = R.string.search_items),
        onValueChange = { _curSearchRequest = it },
        textStyle = TextStyle(
            color = if (curSearchRequest == null) Color.DarkGray else Color.Black
        ),
        modifier = Modifier
            .width(300.dp)
            .height(58.dp)
            .padding(start = 5.dp, top = 10.dp, end = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .shadow(
                    elevation = 12.dp,
                    spotColor = Color.DarkGray,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(
                    Color.White,
                    RoundedCornerShape(7.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(id = R.drawable.magn_glass),
                contentDescription = "Magn_Glass",
                modifier = Modifier
                    .size(23.dp),
                tint = Color.DarkGray
            )
            Spacer(modifier = Modifier.width(10.dp))
            it()
        }
    }

    Box(
        modifier = Modifier
            .size(58.dp)
            .padding(top = 10.dp, end = 5.dp)
            .shadow(
                elevation = 12.dp,
                spotColor = OurRed,
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = OurRed,
                RoundedCornerShape(12.dp)
            )
            .clickable {

            },
        contentAlignment = Alignment.Center,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Filter",
                tint = Color.White
            )
        }
    )
}