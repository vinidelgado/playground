package com.vini.playground

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.vini.playground.navigation.MainNavGraph
import com.vini.playground.navigation.ScreenRoutes
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenNavigationTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController

    @Before
    fun setup() {
        composeTestRule.activity.setContent {
            navController = rememberNavController()
            MainNavGraph(navController = navController)
        }
    }

    @Test
    fun testNavigatingFromFirstScreenToSecond() {
        composeTestRule.apply {
            onNodeWithText("cards").performClick()

            waitForIdle()
            val route = navController.currentDestination?.route
            Assert.assertEquals(route, ScreenRoutes.CardItauScreen.route)
        }
    }

}