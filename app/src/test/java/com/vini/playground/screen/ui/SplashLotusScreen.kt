package com.vini.playground.screen.ui

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vini.playground.ScreenshotTest
import com.vini.playground.screenshot
import com.vini.playground.ui.screens.splashs.LotusSplashScreen
import org.junit.Test
import org.robolectric.annotation.Config

private lateinit var navController: NavHostController
class SplashLotusScreen : ScreenshotTest() {
    @Test
    @Config(qualifiers = "night")
    fun lotusSplashScreen() = screenshot {
        navController = rememberNavController()
        LotusSplashScreen(navController)
    }
}