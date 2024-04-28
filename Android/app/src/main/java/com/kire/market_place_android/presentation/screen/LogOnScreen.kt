package com.kire.market_place_android.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kire.test.R

//@Destination(start = true)
@Composable
fun LogOnScreen(
    paddingValues: PaddingValues = PaddingValues(52.dp)
){
    val nameState = remember { mutableStateOf("") }
    val numberState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val repeatPasswordState = remember { mutableStateOf("") }

    val stateList = 
        listOf(
            nameState,
            numberState,
            emailState,
            passwordState,
            repeatPasswordState
        )
    val hintList =
        listOf(
            R.string.name_hint,
            R.string.phone_hint,
            R.string.email_hint,
            R.string.password_hint,
            R.string.password_repeat_hint
        )
    val iconList =
        listOf(
            R.drawable.user,
            R.drawable.phone_call,
            R.drawable.accept_email,
            R.drawable.key,
            R.drawable.double_key
        )
            
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ){

        Column(
            verticalArrangement = Arrangement.spacedBy(36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(id = R.string.login_header),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Column(
                modifier = Modifier
                    .wrapContentSize(),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                stateList.zip(iconList).zip(hintList).forEach { stateIconHint ->
                    BasicTextField(
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth()
                            .shadow(
                                elevation = 12.dp,
                                spotColor = Color(0xFFB20000),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .background(Color.White)
                            .padding(16.dp),
                        value = stateIconHint.first.first.value,
                        onValueChange = { input: String ->
                            stateIconHint.first.first.value = input
                        },
                        textStyle = LocalTextStyle.current.copy(
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W600,
                        ),
                        decorationBox = { innerTextField ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = stateIconHint.first.second),
                                    contentDescription = null,
                                    tint = Color(0xFFB20000),
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                                Box {
                                    if (stateIconHint.first.first.value.isEmpty())
                                        Text(
                                            text = stringResource(id = stateIconHint.second),
                                            fontWeight = FontWeight.W400,
                                            color = Color.Gray
                                        )
                                    innerTextField()
                                }
                            }
                        }
                    )
                }


            }



            Column(
                modifier = Modifier
                    .wrapContentSize(),
                verticalArrangement = Arrangement.spacedBy(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        /*TODO*/
                    },
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB20000)
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.logon_button),
                        fontSize = 16.sp
                    )
                }

                Text(
                    text = stringResource(id = R.string.login_suggestion),
                    fontWeight = FontWeight.W400,
                    color = Color.Gray,
                    modifier = Modifier
                        .drawBehind {
                            val strokeWidthPx = 1.dp.toPx()
                            val verticalOffset = size.height - 1.sp.toPx()
                            drawLine(
                                color = Color.Gray,
                                strokeWidth = strokeWidthPx,
                                start = Offset(0f, verticalOffset),
                                end = Offset(size.width, verticalOffset)
                            )
                        }
                        .pointerInput(Unit) {
                            detectTapGestures {
                                /*TODO*/
                            }
                        }
                )
            }
        }
    }

}

@Preview
@Composable
fun LogOnScreenPreview(){
    LogOnScreen()
}