@file:OptIn(ExperimentalRoborazziApi::class)

package com.vini.playground

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.ExperimentalRoborazziApi
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.captureRoboImage
import com.vini.playground.ui.screens.splashs.LotusSplash
import com.vini.playground.ui.theme.PlaygroundTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [33], qualifiers = RobolectricDeviceQualifiers.Pixel5)
class LoginTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    val directoryName = "LoginTest"

    @Test
    fun testGreeting() {
        composeTestRule.setContent {
            PlaygroundTheme {
                LotusSplash()
            }
        }

        composeTestRule.onRoot().captureRoboImage(
            filePath = "src/test/screenshots/$directoryName/greeting.png",
            roborazziOptions = RoborazziOptions(
                recordOptions =
                RoborazziOptions.RecordOptions(resizeScale = 0.5)
            )
        )
    }
}