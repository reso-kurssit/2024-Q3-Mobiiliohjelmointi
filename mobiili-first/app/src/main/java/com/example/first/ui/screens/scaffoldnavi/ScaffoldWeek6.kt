package com.example.first.ui.screens.scaffoldnavi

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.first.R
import com.example.first.ui.theme.SolidBlue
import androidx.compose.material3.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(navController: NavController, title: String, showBackButton: Boolean) {
    var expanded by remember { mutableStateOf(false) }


    TopAppBar(
        title = {
            Text(
                title,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            ) },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "More options")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            ) {

                DropdownMenuItem(
                    { Text(text = stringResource(R.string.week6info), color = SolidBlue) },
                    onClick = { navController.navigate("info"); expanded = false }
                )
                DropdownMenuItem(
                    { Text(text = stringResource(R.string.week6settings), color = SolidBlue) },
                    onClick = { navController.navigate("settings"); expanded = false }
                )
            }
        }
    )
}

@Composable
fun reusableModifier(): Modifier {
    return Modifier
        .fillMaxSize()
        .padding(12.dp)
        .background(MaterialTheme.colorScheme.surface)
}

@Composable
fun InfoScreen(navController: NavController) {
    val textStyle = MaterialTheme.typography.bodyLarge.copy(
        color = MaterialTheme.colorScheme.onSecondaryContainer
    )

    Box(
        modifier = reusableModifier()
    ) {
        Text(text = stringResource(R.string.week6infoContent), modifier = Modifier.padding(16.dp),
            style = textStyle )
    }
}

@Composable
fun Week6MainScreen(navController: NavController) {
    val textStyle = MaterialTheme.typography.bodyLarge.copy(
        color = MaterialTheme.colorScheme.onSecondaryContainer
    )

    Box(
        modifier = reusableModifier()
    ) {
        Text(text = stringResource(R.string.week6mainContent), modifier = Modifier.padding(16.dp),
            style = textStyle)

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 84.dp)

        ) {
            Text(text = stringResource(R.string.gotoHome),
                style = textStyle)
        }
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    val textStyle = MaterialTheme.typography.bodyLarge.copy(
        color = MaterialTheme.colorScheme.onSecondaryContainer
    )

    Box(
        modifier = reusableModifier()
    ) {
        Text(text = stringResource(R.string.week6settingsContent), modifier = Modifier.padding(16.dp),
            style = textStyle)
    }
}
