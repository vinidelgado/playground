package com.vini.playground.screen.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vini.playground.ScreenshotTest
import com.vini.playground.screenshot
import com.vini.playground.ui.components.ButtonItauPrimary
import org.junit.Test
import org.robolectric.annotation.Config

class ButtonItauPrimaryTest : ScreenshotTest() {
    @Test
    @Config(qualifiers = "night")
    fun buttonDefault() = screenshot {
        ButtonItauPrimary(
            text = "ButtonTest",
            isEnabled = true,
            onClickButton = {}
        )
    }

    @Test
    @Config(qualifiers = "night")
    fun buttonDisabled() = screenshot {
        ButtonItauPrimary(
            text = "Disabled",
            isEnabled = false,
            onClickButton = {}
        )
    }


    @Test
    @Config(qualifiers = "night")
    fun buttonChangeSize() = screenshot {
        ButtonItauPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            text = "Change Size",
            isEnabled = false,
            onClickButton = {}
        )
    }
}