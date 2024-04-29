package com.kire.market_place_android.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val LocalExtendedColors = staticCompositionLocalOf {
    MarketExtendedColors(
        redAccent  = Color(0xFFB20000),
        black10 = Color(0, 0, 0, 25),
        greenPrice = Color(8, 78, 0, 255),
        profileBar = Color(0xFFEDEDED)
    )
}


@Composable
fun MarketExtendedTheme(
    content: @Composable () -> Unit
) {
    val extendedColors = MarketExtendedColors(
        redAccent = Color(0xFFB20000),
        black10 = Color(0, 0, 0, 25),
        greenPrice = Color(8, 78, 0, 255),
        profileBar = Color(0xFFEDEDED)
    )
    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        Market_Place_AndroidTheme(
            /* colors = ..., typography = ..., shapes = ... */
            content = content
        )
    }
}

// Use with eg. ExtendedTheme.colors.tertiary
object ExtendedTheme {
    val colors: MarketExtendedColors
        @Composable
        get() = LocalExtendedColors.current
}
