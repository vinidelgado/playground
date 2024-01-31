package com.vini.playground.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.playground.R
import com.vini.playground.ui.annotation.UiModePreviews
import com.vini.playground.ui.theme.PlaygroundTheme

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    profileImage: Painter,
    name: String,
    description: String,
    isHistoryEnabled: Boolean = false
) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .padding(horizontal = 24.dp, vertical = 8.dp)
        ) {
            PhotoProfile(
                profileImage = profileImage,
                contentDescription = name,
                isHistoryEnabled = isHistoryEnabled
            )
            Spacer(modifier = Modifier.width(8.dp))
            if (description.isEmpty()) {
                Text(
                    text = description,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 18.sp
                )
            } else {
                Column(
                    modifier = Modifier.height(64.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 18.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = description,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun PhotoProfile(
    profileImage: Painter,
    contentDescription: String,
    isHistoryEnabled: Boolean
) {
    Box {
        if (isHistoryEnabled) {
            Image(
                modifier = Modifier
                    .size(64.dp) // Set the size of the image to 70dp
                    .clip(CircleShape) // Clip the image to a circle shape
                    .border( // Add a border to the image
                        width = 4.dp, // The width of the border is 2dp
                        brush = Brush.linearGradient( // The color of the border is a linear gradient
                            colors = listOf(
                                Color.Yellow,
                                Color.Red,
                                Color.Magenta
                            ), // The colors of the gradient
                            start = Offset(0f, 0f), // The start point of the gradient
                            end = Offset(70f, 70f) // The end point of the gradient
                        ),
                        shape = CircleShape // The shape of the border is a circle
                    )
                    .clickable(onClick = {}), // Make the image clickable
                contentScale = ContentScale.Crop,
                painter = profileImage,
                contentDescription = contentDescription
            )
        } else {
            Image(
                modifier = Modifier
                    .size(64.dp) // Set the size of the image to 70dp
                    .clip(CircleShape) // Clip the image to a circle shape
                    .clickable(onClick = {}), // Make the image clickable
                contentScale = ContentScale.Crop,
                painter = profileImage,
                contentDescription = contentDescription
            )
        }
    }
}

@UiModePreviews
@Composable
private fun ProfileCardPreview() {
    PlaygroundTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            ProfileCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                profileImage = painterResource(id = R.drawable.ic_avatar),
                name = "Nelson Jones",
                description = "Product Manager Sr"
            )
            Spacer(modifier = Modifier.height(16.dp))
            ProfileCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                profileImage = painterResource(id = R.drawable.ic_avatar),
                name = "Nelson Jones",
                description = "Product Manager Sr",
                isHistoryEnabled = true
            )
        }
    }
}