package com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.kire.market_place_android.presentation.constant.Strings
import com.kire.market_place_android.presentation.model.IRequestResult
import com.kire.test.R

@Composable
fun RequestResultMessage(
    requestResult: IRequestResult
){
    val context = LocalContext.current

    LaunchedEffect(requestResult) {
        if (requestResult is IRequestResult.SuccessfullyDone)
            Toast.makeText(
                context,
                Strings.SUCCESS,
                LENGTH_SHORT
            ).show()
        if (requestResult is IRequestResult.Error)
            Toast.makeText(
                context,
                if (requestResult.message?.isNotEmpty() == true)
                    requestResult.message
                else Strings.SOME_ERROR,
                LENGTH_SHORT
            ).show()
    }
}