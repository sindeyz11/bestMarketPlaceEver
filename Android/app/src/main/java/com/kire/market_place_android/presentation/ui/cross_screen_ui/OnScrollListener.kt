package com.kire.market_place_android.presentation.ui.cross_screen_ui

import androidx.compose.foundation.lazy.LazyListState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun OnScrollListener(
    listState: LazyListState,
    isShown: (Boolean) -> Unit
){
    var previousVisibleItemScrollOffset by rememberSaveable {
        mutableIntStateOf(0)
    }

    listState.apply {
        LaunchedEffect(firstVisibleItemScrollOffset){
            if (firstVisibleItemScrollOffset - previousVisibleItemScrollOffset > 50){
                isShown(false)
                previousVisibleItemScrollOffset = firstVisibleItemScrollOffset
            }

            if (firstVisibleItemScrollOffset - previousVisibleItemScrollOffset < -50){
                isShown(true)
                previousVisibleItemScrollOffset = firstVisibleItemScrollOffset
            }

        }
    }
}