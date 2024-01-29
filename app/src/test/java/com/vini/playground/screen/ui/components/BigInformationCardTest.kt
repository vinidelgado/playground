package com.vini.playground.screen.ui.components

import com.vini.playground.ScreenshotTest
import com.vini.playground.screenshot
import com.vini.playground.ui.components.BigInformationCard
import com.vini.playground.ui.theme.PlaygroundTheme
import org.junit.Test
import org.robolectric.annotation.Config

class BigInformationCardTest : ScreenshotTest() {
    @Test
    @Config(qualifiers = "night")
    fun bigInformationCardDefault() = screenshot {
        PlaygroundTheme {
            BigInformationCard(
                text = "Web Design templates Selection",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elitsed do eiusmod.",
                works = "135",
                percentage = 0.45f
            )
        }
    }

    @Test
    @Config(qualifiers = "night")
    fun bigInformationCard0Percentage() = screenshot {
        PlaygroundTheme {
            BigInformationCard(
                text = "Web Design templates Selection",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elitsed do eiusmod.",
                works = "150",
                percentage = 0.0f
            )
        }
    }

    @Test
    @Config(qualifiers = "night")
    fun bigInformationCard100Percentage() = screenshot {
        PlaygroundTheme {
            BigInformationCard(
                text = "Web Design templates Selection",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elitsed do eiusmod.",
                works = "100",
                percentage = 1.00f
            )
        }
    }

    @Test
    @Config(qualifiers = "night")
    fun bigInformationCardError() = screenshot {
        PlaygroundTheme {
            BigInformationCard(
                text = "Web Design templates Selection",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elitsed do eiusmod.",
                works = "200",
                percentage = 2.00f
            )
        }
    }
}