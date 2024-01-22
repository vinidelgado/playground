package com.vini.playground.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.vini.playground.ui.theme.CardBorder
import com.vini.playground.ui.theme.PlaygroundTheme

@Composable
fun HomeListCard(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes vectorIcon: Int = R.drawable.ic_card,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, CardBorder),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = modifier
                .defaultMinSize(80.dp, 80.dp)
                .clickable { onClick() },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(32.dp)
                    .wrapContentHeight(),
                imageVector = ImageVector.vectorResource(id = vectorIcon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier.wrapContentWidth(),
                text = text,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        }
    }
}

@UiModePreviews
@Composable
private fun HomeListCardPreview() {
    PlaygroundTheme {
        HomeListCard(text = "Splash", onClick = {})
    }
}

