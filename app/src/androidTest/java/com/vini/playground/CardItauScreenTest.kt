package com.vini.playground

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.vini.playground.ui.screens.CardItauScreen
import org.junit.Rule
import org.junit.Test


class CardItauScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCardItauScreen() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            CardItauScreen(navController = navController)
        }

        // Example: Verify if the screen contains the expected title
        composeTestRule.onNodeWithText("Card Itau").assertExists()
    }
}
