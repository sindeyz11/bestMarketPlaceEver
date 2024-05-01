package com.kire.market_place_android.presentation.ui.admin_panel_items_edit_screen_ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdminPanelIconField(
    modifier: Modifier,
    @DrawableRes icon: Int?,
    @StringRes hintText: Int,
    maxLines: Int = 1
) {
    /*var textValue by remember {
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

*/
}