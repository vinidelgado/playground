package com.vini.playground.ui.screens.splashs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vini.playground.R
import com.vini.playground.ui.annotation.UiModePreviews
import com.vini.playground.ui.theme.LoginLotusPrimary
import com.vini.playground.ui.theme.PlaygroundTheme

@Composable
fun LotusSplashScreen(navController: NavHostController) {
    PlaygroundTheme {
        LotusSplash()
    }
}

@Composable
fun LotusSplash() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .wrapContentHeight(),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_login_lotus),
            contentDescription = null,
            colorFilter = ColorFilter.tint(LoginLotusPrimary),
            contentScale = ContentScale.FillWidth
        )
    }
}


@UiModePreviews
@Composable
private fun LotusSplashScreenPreview() {
    PlaygroundTheme {
        LotusSplash()
    }
}