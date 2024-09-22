package com.example.first.screens.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Home


@Composable
fun CustomBottomAppBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {

        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(20.dp)
        ) {
            BottomNavigationButton(
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home", modifier = Modifier.size(30.dp)) },
                onClick = { navController.navigate("home") }
            )

        }
    }
}

@Composable
fun BottomNavigationButton(icon: @Composable () -> Unit, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .size(40.dp)
            .wrapContentSize()
    ) {
        icon()
    }
}