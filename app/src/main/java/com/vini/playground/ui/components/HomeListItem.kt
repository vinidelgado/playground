package com.vini.playground.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.playground.R

@Composable
fun HomeListItem(modifier: Modifier, text: String, onClick: () -> Unit) {
    Row(modifier = modifier.clickable { onClick() }) {
        Image(
            modifier = Modifier
                .size(25.dp)
                .wrapContentHeight(),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_card),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            modifier = Modifier.wrapContentWidth(),
            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}
