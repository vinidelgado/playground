package com.vini.core.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.vini.core.ui.components.QuantityToggle
import com.vini.core.ui.theme.PlaygroundTheme

@Composable
fun PlaygroundCatalog() {
    PlaygroundTheme() {
        Surface {
            val contentPadding = WindowInsets
                .systemBars
                .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                .asPaddingValues()
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = contentPadding,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text(
                        text = "Playground Catalog",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
                item { Text("AnimatedButton", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(mainAxisSpacing = 16.dp) {
                        QuantityToggle(
                            quantity = 0,
                            onIncrementQuantity = { },
                            onDecrementQuantity = { },
                        )
                        QuantityToggle(
                            quantity = 1,
                            onIncrementQuantity = { },
                            onDecrementQuantity = { },
                        )
                        val quantity = remember { mutableStateOf(0) }
                        QuantityToggle(
                            quantity = quantity.value,
                            onIncrementQuantity = { quantity.value = quantity.value + 1 },
                            onDecrementQuantity = { quantity.value = quantity.value - 1 },
                            textSelected = "Added",
                            textUnselected = "Select me"
                        )
                    }
                }
            }
        }
    }
}