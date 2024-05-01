package com.kire.market_place_android.presentation.screen.admin_panel_items_edit_screen_ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kire.market_place_android.presentation.theme.ExtendedTheme

@Composable
fun AdminPanelIconField(
    modifier: Modifier,
    @DrawableRes icon: Int?,
    @StringRes hintText: Int,
    maxLines: Int = 1
) {
    var textValue by remember {
        mutableStateOf("")
    }


    BasicTextField(
        modifier = modifier
            .shadow(
                elevation = 12.dp,
                spotColor = Color.LightGray,
                shape = RoundedCornerShape(12.dp)
            )
            .background(Color.White),
        value = textValue,
        onValueChange = {
            textValue = it
        },
        maxLines = maxLines
    ) { textField ->

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(horizontal = 10.dp),
                painter = painterResource(id = icon!!),
                contentDescription = "icon",
                tint = ExtendedTheme.colors.redAccent
            )

            Box {
                if (textValue.isEmpty())
                    Text(
                        text = stringResource(id = hintText),
                        fontWeight = FontWeight.W400,
                        color = Color.Gray
                    )
                textField()
            }
        }
    }


}