package com.vini.myplayground.navigation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vini.playground.navigation.ScreenRoutes
import com.vini.playground.ui.screens.CardItauScreen
import com.vini.playground.ui.screens.HomeScreen

const val MEDIUM_DURATION = 300
const val REVERSE_MEDIUM_DURATION = -300
@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.HomeScreen.route
    ) {
        composable(
            ScreenRoutes.HomeScreen.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { REVERSE_MEDIUM_DURATION },
                    animationSpec = tween(
                        durationMillis = MEDIUM_DURATION,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(MEDIUM_DURATION))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { REVERSE_MEDIUM_DURATION },
                    animationSpec = tween(
                        durationMillis = MEDIUM_DURATION,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(MEDIUM_DURATION))
            },
        ) {
            HomeScreen(navController)
        }

        composable(
            ScreenRoutes.CardItauScreen.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { MEDIUM_DURATION },
                    animationSpec = tween(
                        durationMillis = MEDIUM_DURATION,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(MEDIUM_DURATION))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { MEDIUM_DURATION },
                    animationSpec = tween(
                        durationMillis = MEDIUM_DURATION,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(MEDIUM_DURATION))
            },
        ) {
            CardItauScreen(
                navController = navController,
            )
        }

    }
}
