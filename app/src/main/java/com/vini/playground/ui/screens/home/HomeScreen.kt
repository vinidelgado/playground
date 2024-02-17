package com.vini.playground.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vini.playground.navigation.ScreenRoutes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        ButtonComponent(
            buttonText = "Simple Text",
            onClick = {
                navController.navigate(ScreenRoutes.LoginLotusScreen.route)
            }
        )
        Divider(color = Color.Black)
        ButtonComponent(
            buttonText = "Simple Text",
            onClick = {
                navController.navigate(ScreenRoutes.CardItauScreen.route)
            }
        )
    }
}

@Composable
fun ButtonComponent(buttonText: String, onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            text = buttonText,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}