package com.vini.playground.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vini.playground.ui.components.CardItau
import com.vini.playground.ui.theme.HomeAppBarTitleColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CardItauScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = HomeAppBarTitleColor,
                ),
                title = {
                    Text(text = "Card Itau",modifier = Modifier.testTag("title"))
                },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
            )
        },
    ) { innerPadding ->
        CardItauScreenContent(innerPadding)
    }
}

@Composable
private fun CardItauScreenContent(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(12.dp)
        ) {
            CardItau(
                title = "cartão virtual",
                message = "use o mesmo cartão virtual para todas as suas compras online, pontuais " +
                        "ou recorrentes, e tenha ainda mais segurança",
                buttonTextPrimary = "cartão virtual",
                buttonTextSecondary = "gerar cartão"
            )
            Spacer(modifier = Modifier.height(24.dp))
            CardItau(
                title = "cartão virtual",
                message = "use o mesmo cartão virtual para todas as suas compras online, pontuais" +
                        " ou recorrentes, e tenha ainda mais segurança",
                buttonTextPrimary = "cartão virtual",
            )
            Spacer(modifier = Modifier.height(24.dp))
            CardItau(
                title = "cartão virtual",
                message = "use o mesmo cartão virtual para todas as suas compras online, pontuais " +
                        "ou recorrentes, e tenha ainda mais segurança",
                buttonTextSecondary = "gerar cartão"
            )
            Spacer(modifier = Modifier.height(24.dp))
            CardItau(
                title = "cartão virtual",
                message = "use o mesmo cartão virtual para todas as suas compras online, pontuais " +
                        "ou recorrentes, e tenha ainda mais segurança",
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}