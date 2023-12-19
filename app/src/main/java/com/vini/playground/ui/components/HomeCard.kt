package com.vini.playground.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.playground.R
import com.vini.playground.ui.annotation.UiModePreviews
import com.vini.playground.ui.theme.HomeCardTextColor
import com.vini.playground.ui.theme.PlaygroundTheme

@Composable
fun HomeCard(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Card(
        modifier = modifier.clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 12.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Image(
                        modifier = Modifier
                            .size(25.dp)
                            .wrapContentHeight(),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_card),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(HomeCardTextColor),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        modifier = Modifier.wrapContentWidth(),
                        text = text,
                        color = HomeCardTextColor,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                }
                Image(
                    modifier = Modifier
                        .size(20.dp)
                        .wrapContentHeight(),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(HomeCardTextColor),
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}


@UiModePreviews
@Composable
private fun CardItauPreview() {
    PlaygroundTheme {
        HomeCard(text = "cartão virtual", onClick = {})
    }
}

@UiModePreviews
@Composable
private fun CardItauScreenPreview() {
    PlaygroundTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(12.dp)
            ) {
                HomeCard(text = "cartão virtual", onClick = {})
            }
        }
    }
}