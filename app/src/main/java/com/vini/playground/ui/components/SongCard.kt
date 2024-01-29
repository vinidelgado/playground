package com.vini.playground.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.playground.R
import com.vini.playground.ui.annotation.UiModePreviews
import com.vini.playground.ui.theme.PlaygroundTheme

@Composable
fun SongCard(
    modifier: Modifier = Modifier,
    text: String,
    buttonText: String
) {
    Card(
        modifier = modifier
    ) {
        Box(
            modifier = modifier, contentAlignment = Alignment.BottomStart
        ) {
            SongCardBody(contentDescription = text)
            SongCardInformationButton(text = text, buttonText = buttonText)
        }
    }
}


@Composable
fun SongCardInformationButton(text: String, buttonText: String) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text(
            text = text,
            fontSize = 42.sp,
            fontWeight = FontWeight.Black,
            color = Color.White,
            lineHeight = 40.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                disabledContainerColor = Color.LightGray
            )
        ) {
            Text(
                text = buttonText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Black,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_play_song),
                contentDescription = "Play Song"
            )
        }
    }
}

@Composable
fun SongCardBody(contentDescription: String) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.ic_photo_beach),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = size.height / 3,
                    endY = size.height
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.Multiply)
                }
            }
        )
    }
}

@UiModePreviews
@Composable
private fun SongCardCardPreview() {
    PlaygroundTheme {
        Box(modifier = Modifier.fillMaxSize().padding(24.dp)) {
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