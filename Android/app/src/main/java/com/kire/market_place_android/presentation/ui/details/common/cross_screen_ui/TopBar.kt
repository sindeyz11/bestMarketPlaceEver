package com.kire.market_place_android.presentation.ui.details.common.cross_screen_ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight

import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.navigation.util.getDirection
import com.kire.market_place_android.presentation.navigation.util.getIconTop
import com.kire.market_place_android.presentation.navigation.util.getLabel
import com.kire.market_place_android.presentation.navigation.util.getPlusButton
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelItemsEditScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelItemsScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.AdminPanelPickUpScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.LogInScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.OrderScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ProfileScreenDestination
import com.kire.market_place_android.presentation.ui.screen.destinations.ShoppingScreenDestination
import com.kire.market_place_android.presentation.ui.theme.ExtendedTheme

import com.kire.test.R

import com.ramcosta.composedestinations.navigation.DestinationsNavigator

import kotlinx.coroutines.launch

/**
 * Топ бар приложения
 *
 * @param logOut Выход из аккаунта
 * @param destination Направление
 * @param curPickUpPoint Текущий пункт выдачи
 * @param orderCode Код заказа
 * @param paddingValuesTop Отступы от краев экрана
 * @param onPlusClick Обработчик кнопки "+"
 * @param navigator Для навигации между экранами
 * @param searchBar Панель поиска
 * @param modifier Модификатор
 *
 * @author Michael Gontarev (KiREHwYE)*/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopBar(
    logOut: (suspend () -> Unit)? = null,
    destination: AppDestinations,
    curPickUpPoint: String? = "г. Краснодар, ул. Ставропольская, д. 149, эт. 1, кб. 133",
    orderCode: String? = "XXX-XXX",
    paddingValuesTop: Dp = 84.dp,
    onPlusClick: (() -> Unit)? = null,
    navigator: DestinationsNavigator? = null,
    searchBar: @Composable () -> Unit = {},
    modifier: Modifier = Modifier
) {

    val coroutineScope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(top = paddingValuesTop),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {

                //Replace resource on ?: right with default icon
                Icon(
                    painter = painterResource(id = destination.getIconTop() ?: R.drawable.shopping_top_bar),
                    contentDescription = null,
                    tint = ExtendedTheme.colors.redAccent,
                    modifier = Modifier
                        .size(34.dp)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                navigator?.popBackStack(OrderScreenDestination, inclusive = true)
                            }
                        }
                )

                if (destination.getDirection() == ShoppingScreenDestination) {
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(start = 4.dp),
                        verticalArrangement = Arrangement.spacedBy(2.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = stringResource(id = R.string.pick_up_point),
                            fontWeight = FontWeight.Light,
                            fontSize = 15.sp,
                            color = Color.DarkGray,
                            modifier = Modifier
                                .basicMarquee(
                                    animationMode = MarqueeAnimationMode.Immediately,
                                    delayMillis = 0
                                )
                        )

                        Text(
                            text = curPickUpPoint ?: "",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .basicMarquee(
                                    animationMode = MarqueeAnimationMode.Immediately,
                                    delayMillis = 0
                                )
                        )
                    }
                } else
                    Text(
                        text =
                        if (destination.getDirection() == OrderScreenDestination)
                            stringResource(id = destination.getLabel()) + " " + stringResource(id = R.string.number) + orderCode.toString()
                        else
                            stringResource(id = destination.getLabel()),
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .basicMarquee(
                                animationMode = MarqueeAnimationMode.Immediately,
                                delayMillis = 0
                            )
                    )
            }

            destination.getPlusButton()?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = "plus_bold",
                    tint = ExtendedTheme.colors.redAccent,
                    modifier = Modifier
                        .size(30.dp)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                when (destination.getDirection()) {
                                    is ProfileScreenDestination -> {
                                        coroutineScope.launch {
                                            if (logOut != null)
                                                logOut()
                                            navigator?.navigate(LogInScreenDestination) {
                                                popUpTo(LogInScreenDestination.route) {
                                                    inclusive = true
                                                }
                                            }
                                        }
                                    }

                                    is AdminPanelPickUpScreenDestination, is AdminPanelItemsScreenDestination ->
                                        if (onPlusClick != null)
                                            onPlusClick()
                                }
                            }
                        }

                )
            }
        }

        searchBar()

        Spacer(modifier = Modifier.height(12.dp))
    }
}