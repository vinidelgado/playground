package com.vini.playground.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.playground.ui.annotation.UiModePreviews
import com.vini.playground.ui.theme.PlaygroundTheme

const val DEFAULT_PERCENTAGE = 100

@Composable
fun BigInformationCard(
    modifier: Modifier = Modifier,
    text: String,
    description: String,
    works: String,
    percentage: Float
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = modifier
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            BigInformationCardBody(text, description)
            Spacer(modifier = Modifier.height(16.dp))
            BigInformationCardPercentage(works = works, percentage = percentage)
        }
    }
}

@Composable
fun BigInformationCardPercentage(works: String, percentage: Float) {
    Column {
        val intPercentage = (percentage * DEFAULT_PERCENTAGE).toInt()
        val text = "$works Works / $intPercentage %"
        val color = if (isSystemInDarkTheme()) Color.White else Color.Black
        Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(16.dp))
        LinearProgressIndicator(
            progress = percentage,
            modifier = Modifier.fillMaxWidth(),
            color = color,
            trackColor = color.copy(alpha = 0.2f),
            strokeCap = StrokeCap.Round
        )
    }
}

@Composable
fun BigInformationCardBody(text: String, description: String) {
    Column {
        Text(text = text, fontSize = 32.sp, fontWeight = FontWeight.Black, lineHeight = 42.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = description, fontSize = 18.sp, fontWeight = FontWeight.Light)
    }
}

@UiModePreviews
@Composable
private fun BigInformationCardPreview() {
    PlaygroundTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            BigInformationCard(
                modifier = Modifier.fillMaxWidth().wrapContentSize(),
                text = "Web Design templates Selection",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elitsed do eiusmod.",
                works = "135",
                percentage = 0.45f
            )
        }
    }
}