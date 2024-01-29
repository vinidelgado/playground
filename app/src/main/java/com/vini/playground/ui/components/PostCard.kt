package com.vini.playground.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddReaction
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.playground.ui.annotation.UiModePreviews
import com.vini.playground.ui.theme.PlaygroundTheme


@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    text: String,
    description: String,
    dataPost: List<PostData>,
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = modifier
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            PostCardTitle(text)
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = description,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 32.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(items = dataPost, itemContent = { item ->
                    DataPost(
                        text = item.text,
                        contentDescription = item.contentDescription,
                        imageVector = item.imageVector
                    )
                })
            }
        }
    }
}

@Composable
fun PostCardTitle(text: String) {
    val exampleColors = listOf(Color(0xFFFF512F), Color(0xFFF09819))
    Text(
        text, fontSize = 48.sp, fontWeight = FontWeight.Black,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = exampleColors,
                tileMode = TileMode.Mirror
            ),
            fontSize = 30.sp
        )
    )
}

@Composable
fun DataPost(text: String, contentDescription: String, imageVector: ImageVector) {
    val colorTint = if(isSystemInDarkTheme()){
        Color.White
    }else{
        Color.Black
    }
    Row {
        Image(
            modifier = Modifier.size(24.dp),
            imageVector = imageVector,
            contentDescription = contentDescription,
            colorFilter = ColorFilter.tint(colorTint)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}

data class PostData(val text: String, val imageVector: ImageVector, val contentDescription: String)

@UiModePreviews
@Composable
private fun PostCardPreview() {
    PlaygroundTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            val dataPost = listOf(
                PostData(
                    text = "20k",
                    contentDescription = "Like",
                    imageVector = Icons.Outlined.Favorite
                ),
                PostData(
                    text = "34",
                    contentDescription = "Like",
                    imageVector = Icons.Outlined.Share
                ),
                PostData(
                    text = "567",
                    contentDescription = "Like",
                    imageVector = Icons.Outlined.Comment
                ),
                PostData(
                    text = "1k",
                    contentDescription = "Like",
                    imageVector = Icons.Outlined.AddReaction
                )
            )
            PostCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                text = "New card\ndesigns",
                description = "Minim dolor in amet nulla laboris enim dolore.",
                dataPost = dataPost
            )
        }
    }
}
