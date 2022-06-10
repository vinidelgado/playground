package com.vini.core.ui.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vini.core.ui.theme.Gray10
import com.vini.core.ui.theme.PlaygroundTheme
import com.vini.core.ui.theme.Yellow10

private enum class QuantityToggleState { Zero, NonZero }

@Composable
fun QuantityToggle(
    quantity: Int,
    onIncrementQuantity: () -> Unit,
    onDecrementQuantity: () -> Unit,
    textSelected: String = "Added",
    textUnselected: String = "Add"
) {

    val transition =
        updateTransition(
            if (quantity == 0) QuantityToggleState.Zero else QuantityToggleState.NonZero,
            label = ""
        )

    val backgroundColor by transition.animateColor(label = "") { state ->
        when (state) {
            QuantityToggleState.Zero -> Gray10
            QuantityToggleState.NonZero -> Yellow10
        }
    }
    val contentColor by transition.animateColor(label = "") { state ->
        when (state) {
            QuantityToggleState.Zero -> LocalContentColor.current
            QuantityToggleState.NonZero -> LocalContentColor.current
        }
    }
    val borderColor by transition.animateColor(label = "") { state ->
        when (state) {
            QuantityToggleState.Zero -> Gray10
            QuantityToggleState.NonZero -> Yellow10
        }
    }
    val iconSize by transition.animateDp(label = "") { state ->
        when (state) {
            QuantityToggleState.Zero -> 0.dp
            QuantityToggleState.NonZero -> 18.dp
        }
    }

    Surface(
        modifier = Modifier
            .width(110.dp)
            .aspectRatio(2.75f),
        shape = MaterialTheme.shapes.small,
        color = backgroundColor,
        contentColor = contentColor,
        border = BorderStroke(2.dp, borderColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = if (quantity == 0) onIncrementQuantity else onDecrementQuantity),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.Done,
                textSelected,
                modifier = Modifier.size(iconSize)
            )
            Text(
                text = if (quantity == 0) textUnselected else textSelected,
                style = MaterialTheme.typography.button,
                modifier = Modifier.animateContentSize()
            )
        }
    }
}

@Preview
@Composable
fun QuantityToggleDeafultPreview() {
    PlaygroundTheme(darkTheme = false) {
        QuantityToggle(
            quantity = 0,
            onIncrementQuantity = { },
            onDecrementQuantity = { },
        )
    }
}
