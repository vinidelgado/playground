package com.vini.playground.screen.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Modifier
import com.vini.playground.ScreenshotTest
import com.vini.playground.screenshot
import com.vini.playground.ui.components.SongCard
import com.vini.playground.ui.theme.PlaygroundTheme
import org.junit.Test
import org.robolectric.annotation.Config

class SongCardTest: ScreenshotTest() {
    @Test
    @Config(qualifiers = "night")
    fun songCardDefault() = screenshot {
        PlaygroundTheme {
            SongCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                text = "HARDCORE\nMUSIC",
                buttonText = "PLAY NOW"
            )
        }
    }
}