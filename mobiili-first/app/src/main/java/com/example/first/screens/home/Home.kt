package com.example.first.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.first.R
import com.example.first.ui.theme.FirstTheme

@Composable
fun Home(navController: NavController) {

    val textModifier = Modifier
        .padding(horizontal = 12.dp)

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Heading(title = stringResource(R.string.titleHome))

        Text (text = stringResource(R.string.assignmentLocations),
            style = MaterialTheme.typography.titleLarge)

        Row(modifier = textModifier) {
            Text(text = stringResource(R.string.week1_))
        }

        Row(modifier = textModifier) {
            Text(text = stringResource(R.string.week2_))
        }

        Row(modifier = textModifier) {
            Text(text = stringResource(R.string.week3_))
        }

        Row(modifier = textModifier) {
            Text(text = stringResource(R.string.week4_))
        }

        Row(modifier = textModifier) {
            Text(text = stringResource(R.string.week5_))
        }

        Row(modifier = textModifier) {
            Text(text = stringResource(R.string.week6_))
        }

        Row(modifier = textModifier) {
            Text(text = stringResource(R.string.week7_))
        }

        Row(modifier = textModifier) {
            Text(text = stringResource(R.string.week8_))
        }

        Text (text = stringResource(R.string.anotherAssignmet), modifier = textModifier)
    }
}

@Composable
fun DefaultPreview() {
    FirstTheme {
        Home(navController = NavController(LocalContext.current))
    }
}

@Composable
fun Heading(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp)
    )
}