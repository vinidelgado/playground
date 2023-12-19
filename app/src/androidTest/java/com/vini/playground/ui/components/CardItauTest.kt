package com.vini.playground.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class CardItauTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCardItauScreenWithAllParameters() {
        composeTestRule.setContent {
            CardItau(
                title = "cartão virtual",
                message = "use o mesmo cartão virtual para todas as suas compras online, pontuais " +
                        "ou recorrentes, e tenha ainda mais segurança",
                buttonTextPrimary = "cartão virtual",
                buttonTextSecondary = "gerar cartão"
            )
        }

        // Example: Verify if the screen contains the expected title
        composeTestRule.onNodeWithTag("CardItau_title").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_message").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonPrimary").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonSecondary").assertIsDisplayed()
    }

    @Test
    fun testCardItauScreenWithoutMessage() {
        composeTestRule.setContent {
            CardItau(
                title = "cartão virtual",
                buttonTextPrimary = "cartão virtual",
                buttonTextSecondary = "gerar cartão"
            )
        }

        // Example: Verify if the screen contains the expected title
        composeTestRule.onNodeWithTag("CardItau_title").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_message").assertIsNotDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonPrimary").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonSecondary").assertIsDisplayed()
    }

    @Test
    fun testCardItauScreenWithoutButtonPrimary() {
        composeTestRule.setContent {
            CardItau(
                title = "cartão virtual",
                message = "use o mesmo cartão virtual para todas as suas compras online, pontuais " +
                        "ou recorrentes, e tenha ainda mais segurança",
                buttonTextSecondary = "gerar cartão"
            )
        }

        // Example: Verify if the screen contains the expected title
        composeTestRule.onNodeWithTag("CardItau_title").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_message").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonPrimary").assertIsNotDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonSecondary").assertIsDisplayed()
    }

    @Test
    fun testCardItauScreenWithoutButtonSecondary() {
        composeTestRule.setContent {
            CardItau(
                title = "cartão virtual",
                message = "use o mesmo cartão virtual para todas as suas compras online, pontuais " +
                        "ou recorrentes, e tenha ainda mais segurança",
                buttonTextPrimary = "cartão virtual",
            )
        }

        // Example: Verify if the screen contains the expected title
        composeTestRule.onNodeWithTag("CardItau_title").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_message").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonPrimary").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonSecondary").assertIsNotDisplayed()
    }

    @Test
    fun testCardItauScreenMinimalParameters() {
        composeTestRule.setContent {
            CardItau(
                title = "cartão virtual"
            )
        }

        // Example: Verify if the screen contains the expected title
        composeTestRule.onNodeWithTag("CardItau_title").assertIsDisplayed()
        composeTestRule.onNodeWithTag("CardItau_message").assertIsNotDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonPrimary").assertIsNotDisplayed()
        composeTestRule.onNodeWithTag("CardItau_buttonSecondary").assertIsNotDisplayed()
    }
}