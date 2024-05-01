package com.kire.market_place_android.presentation.navigation.Transition

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

import androidx.navigation.NavBackStackEntry

import com.ramcosta.composedestinations.spec.DestinationStyle


object ShoppingScreenTransitions : DestinationStyle.Animated {
    override fun AnimatedContentTransitionScope<NavBackStackEntry>.enterTransition(): EnterTransition {
        return slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)) +
                fadeIn(animationSpec = tween(400, easing = FastOutSlowInEasing))
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.exitTransition(): ExitTransition {
        return slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)) +
                fadeOut(animationSpec = tween(400, easing = FastOutSlowInEasing))
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.popEnterTransition(): EnterTransition {
        return slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing))+
                fadeIn(animationSpec = tween(400, easing = FastOutSlowInEasing))
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.popExitTransition(): ExitTransition {
        return slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)) +
                fadeOut(animationSpec = tween(400, easing = FastOutSlowInEasing))
    }
}