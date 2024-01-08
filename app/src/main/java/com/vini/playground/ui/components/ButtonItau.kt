package com.vini.playground.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vini.playground.ui.annotation.UiModePreviews
import com.vini.playground.ui.theme.DisablePrimaryColor
import com.vini.playground.ui.theme.DisableSecondaryColor
import com.vini.playground.ui.theme.ItauPrimary
import com.vini.playground.ui.theme.ItauPrimaryBorder
import com.vini.playground.ui.theme.ItauSecondary
import com.vini.playground.ui.theme.PlaygroundTheme

@Composable
fun ButtonItauPrimary(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    onClickButton: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClickButton,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = ItauPrimary,
            contentColor = Color.White,
            disabledContainerColor = DisablePrimaryColor.copy(alpha = 0.3f),
            disabledContentColor = DisablePrimaryColor
        ),
        border = BorderStroke(
            1.dp,
            if (isEnabled) ItauPrimaryBorder else DisablePrimaryColor.copy(alpha = 0.7f)
        ),
        shape = RoundedCornerShape(4.dp)

    ) {
        Text(text = text)
    }
}

@Composable
fun ButtonItauSecondary(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    onClickButton: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClickButton,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = ItauSecondary,
            disabledContainerColor = Color.White,
            disabledContentColor = DisablePrimaryColor
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (isEnabled) ItauSecondary else DisableSecondaryColor
        ),
        shape = RoundedCornerShape(4.dp)

    ) {
        Text(text = text, color = if (isEnabled) ItauSecondary else DisableSecondaryColor)
    }
}


@UiModePreviews
@Composable
private fun ButtonItauPrimaryPreview() {
    PlaygroundTheme {
        ButtonItauPrimary(text = "usar cartão virtual", onClickButton = {})
    }
}

@UiModePreviews
@Composable
private fun ButtonItauSecondaryPreview() {
    PlaygroundTheme {
        ButtonItauSecondary(text = "gerar cartão virtual", onClickButton = {})
    }
}

@UiModePreviews
@Composable
private fun ButtonItauPrimaryOnScreenPreview() {
    PlaygroundTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(32.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Default Colors")
                Spacer(modifier = Modifier.height(8.dp))
                ButtonItauPrimary(
                    modifier = Modifier
                        .width(200.dp)
                        .wrapContentHeight(),
                    text = "usar cartão virtual",
                    onClickButton = {}
                )
                ButtonItauSecondary(
                    modifier = Modifier
                        .width(200.dp)
                        .wrapContentHeight(),
                    text = "gerar cartão virtual",
                    onClickButton = {}
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Disabled Colors")
                Spacer(modifier = Modifier.height(8.dp))
                ButtonItauPrimary(
                    modifier = Modifier
                        .width(200.dp)
                        .wrapContentHeight(),
                    text = "usar cartão virtual",
                    isEnabled = false,
                    onClickButton = {}
                )
                ButtonItauSecondary(
                    modifier = Modifier
                        .width(200.dp)
                        .wrapContentHeight(),
                    text = "gerar cartão virtual",
                    isEnabled = false,
                    onClickButton = {}
                )

            }
        }
    }
}

