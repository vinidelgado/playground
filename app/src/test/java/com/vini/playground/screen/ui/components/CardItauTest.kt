package com.vini.playground.screen.ui.components

import com.vini.playground.ScreenshotTest
import com.vini.playground.screenshot
import com.vini.playground.ui.components.CardItau
import org.junit.Test
import org.robolectric.annotation.Config

class CardItauTest : ScreenshotTest() {
    @Test
    @Config(qualifiers = "night")
    fun cardAllParameters() = screenshot {
        CardItau(
            title = "cartão virtual",
            message = "use o mesmo cartão virtual para todas as suas compras online, " +
                    "pontuais ou recorrentes, e tenha ainda mais segurança",
            buttonTextPrimary = "cartão virtual",
            buttonTextSecondary = "gerar cartão"
        )
    }
    @Test
    @Config(qualifiers = "night")
    fun cardWithoutSecondaryButton() = screenshot {
        CardItau(
            title = "cartão virtual",
            message = "use o mesmo cartão virtual para todas as suas compras online, pontuais" +
                    " ou recorrentes, e tenha ainda mais segurança",
            buttonTextPrimary = "cartão virtual",
        )
    }

    @Test
    @Config(qualifiers = "night")
    fun cardWithoutPrimaryButton() = screenshot {
        CardItau(
            title = "cartão virtual",
            message = "use o mesmo cartão virtual para todas as suas compras online, pontuais " +
                    "ou recorrentes, e tenha ainda mais segurança",
            buttonTextSecondary = "gerar cartão"
        )
    }
    @Test
    @Config(qualifiers = "night")
    fun cardWithTitleMessage() = screenshot {
        CardItau(
            title = "cartão virtual",
            message = "use o mesmo cartão virtual para todas as suas compras online, pontuais " +
                    "ou recorrentes, e tenha ainda mais segurança",
        )
    }
}