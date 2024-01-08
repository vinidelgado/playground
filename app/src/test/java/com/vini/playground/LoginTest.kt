package com.vini.playground

import com.vini.playground.ui.screens.splashs.LotusSplash
import com.vini.playground.ui.theme.PlaygroundTheme
import org.junit.Test
import org.robolectric.annotation.Config

class LoginTest : ScreenshotTest() {
    @Test
    @Config(qualifiers = "night")
    fun lotusSplash() = screenshot {
        PlaygroundTheme {
            LotusSplash()
        }
    }
}