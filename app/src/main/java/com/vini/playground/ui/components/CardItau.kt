package com.vini.playground.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.playground.R
import com.vini.playground.ui.annotation.UiModePreviews
import com.vini.playground.ui.theme.CardBorder
import com.vini.playground.ui.theme.ItauPrimary
import com.vini.playground.ui.theme.PlaygroundTheme

@Composable
fun CardItau(
    modifier: Modifier = Modifier,
    @DrawableRes vectorIcon: Int = R.drawable.ic_card,
    title: String,
    message: String? = null,
    buttonTextPrimary: String? = null,
    buttonTextSecondary: String? = null
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, CardBorder),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 14.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            ContentCard(
                vectorIcon = vectorIcon,
                title = title,
                message = message,
                buttonTextPrimary = buttonTextPrimary,
                buttonTextSecondary = buttonTextSecondary
            )
        }
    }
}

@Composable
private fun ContentCard(
    vectorIcon: Int,
    title: String,
    message: String?,
    buttonTextPrimary: String?,
    buttonTextSecondary: String?
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            modifier = Modifier
                .size(25.dp)
                .wrapContentHeight(),
            imageVector = ImageVector.vectorResource(id = vectorIcon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(ItauPrimary),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            modifier = Modifier
                .wrapContentWidth()
                .testTag("CardItau_title"),
            text = title,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
    if (!message.isNullOrEmpty()) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            message,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            fontSize = 12.sp,
            modifier = Modifier.testTag("CardItau_message")
        )
    }
    Spacer(modifier = Modifier.height(12.dp))
    if (!buttonTextPrimary.isNullOrEmpty()) {
        ButtonItauPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("CardItau_buttonPrimary"), text = buttonTextPrimary,
            onClickButton = {}
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
    if (!buttonTextSecondary.isNullOrEmpty()) {
        ButtonItauSecondary(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("CardItau_buttonSecondary"), text = buttonTextSecondary,
            onClickButton = {}
        )
    }
}


@UiModePreviews
@Composable
private fun CardItauPreview() {
    PlaygroundTheme {
        CardItau(
            title = "cartão virtual",
            message = "use o mesmo cartão virtual para todas as suas compras online, " +
                    "pontuais ou recorrentes, e tenha ainda mais segurança",
            buttonTextPrimary = "cartão virtual",
            buttonTextSecondary = "gerar cartão"
        )
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
                CardItau(
                    title = "cartão virtual",
                    message = "use o mesmo cartão virtual para todas as suas compras online, " +
                            "pontuais ou recorrentes, e tenha ainda mais segurança",
                    buttonTextPrimary = "cartão virtual",
                    buttonTextSecondary = "gerar cartão"
                )
            }
        }
    }
}