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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vini.core.ui.theme.*

private enum class QuantityToggleState { Zero, NonZero }

@Composable
fun QuantityToggleScreen() {
    val quantity = remember { mutableStateOf(0) }
    Scaffold(
        topBar = { TopAppBar(title = { Text("TopAppBar") }, backgroundColor = Orange80) },
        drawerContent = { Text(text = "drawerContent") },
        content = {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Simple example",color = Color(0xFFBFBFBF))
                Spacer(modifier = Modifier.height(16.dp))
                QuantityToggle(
                    quantity = quantity.value,
                    onIncrementQuantity = { quantity.value = quantity.value + 1 },
                    onDecrementQuantity = { quantity.value = quantity.value - 1 },
                )
            }
        },
    )
}

@Composable
fun QuantityToggle(
    quantity: Int,
    onIncrementQuantity: () -> Unit,
    onDecrementQuantity: () -> Unit,
) {

    val transition =
        updateTransition(
            if (quantity == 0) QuantityToggleState.Zero else QuantityToggleState.NonZero,
            label = ""
        )

    val backgroundColor by transition.animateColor(label = "") { state ->
        when (state) {
            QuantityToggleState.Zero -> Orange95
            QuantityToggleState.NonZero -> Orange80
        }
    }
    val contentColor by transition.animateColor(label = "") { state ->
        when (state) {
            QuantityToggleState.Zero -> Orange95
            QuantityToggleState.NonZero -> LocalContentColor.current
        }
    }
    val borderColor by transition.animateColor(label = "") { state ->
        when (state) {
            QuantityToggleState.Zero -> Orange95
            QuantityToggleState.NonZero -> Orange80
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
            .width(90.dp)
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
                "ADD",
                modifier = Modifier.size(iconSize)
            )
            Text(
                text = if (quantity == 0) "ADD" else "ADDED",
                style = MaterialTheme.typography.button,
                modifier = Modifier.animateContentSize()
            )
        }
    }
}
