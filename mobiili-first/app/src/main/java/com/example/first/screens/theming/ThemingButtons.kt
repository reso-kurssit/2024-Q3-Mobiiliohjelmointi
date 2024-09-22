package com.example.first.screens.theming

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.first.R
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ColorSwitchingButtons(navController: NavController) {
    var buttonColorIndex by remember { mutableStateOf(0) } // Track the current color index
    val buttonColors = listOf(
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.primary
    )
    val buttonColor = buttonColors[buttonColorIndex % buttonColors.size]

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Heading(title = stringResource(R.string.titleWeek4))

        Text(
            text = stringResource(R.string.boxButtonCounts) + "$buttonColorIndex",
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold
        )

        PressTheButton(buttonColor = buttonColor, onButtonClick = {
            buttonColorIndex++
        })
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

@Composable
fun PressTheButton(buttonColor: androidx.compose.ui.graphics.Color, onButtonClick: () -> Unit) {
    Button(
        onClick = {
            onButtonClick()
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor) // Apply the button color
    ) {
        Text(text = stringResource(R.string.boxPressTheButton))
    }
}
