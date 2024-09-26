package com.example.second.screens.diceroller

import DiceRollerViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.second.R
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DiceRollerScreen(navController: NavController, viewModel: DiceRollerViewModel = viewModel()) {
    val diceRollState by viewModel.diceRollState.collectAsState()

    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = diceRollState.imageResource),
                contentDescription = "D20 dice",
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = "${diceRollState.finalResult}",
                fontSize = 32.sp,
                color = Color.White
            )
        }

        if (diceRollState.specialMessageSuccess.isNotEmpty()) {
            Text(text = diceRollState.specialMessageSuccess, color = Color.Green, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (diceRollState.specialMessageFailure.isNotEmpty()) {
            Text(text = diceRollState.specialMessageFailure, color = Color.Red, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = diceRollState.bonus.toString(),
                onValueChange = { viewModel.updateBonus(it.toIntOrNull() ?: 0) },
                label = { Text(text = stringResource(R.string.textboxBonus)) },
                colors = TextFieldDefaults.colors (
                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiaryContainer,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    focusedLabelColor = MaterialTheme.colorScheme.tertiaryContainer,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
                    focusedTextColor =  MaterialTheme.colorScheme.tertiaryContainer,
                    disabledTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                    focusedContainerColor = MaterialTheme.colorScheme.onTertiary,
                    disabledContainerColor = MaterialTheme.colorScheme.tertiary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
                ),
                modifier = Modifier.width(150.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            TextField(
                value = diceRollState.penalty.toString(),
                onValueChange = { viewModel.updatePenalty(it.toIntOrNull() ?: 0) },
                label = { Text(text = stringResource(R.string.textboxPenalty)) },
                colors = TextFieldDefaults.colors (
                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiaryContainer,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    focusedLabelColor = MaterialTheme.colorScheme.tertiaryContainer,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
                    focusedTextColor =  MaterialTheme.colorScheme.tertiaryContainer,
                    disabledTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                    focusedContainerColor = MaterialTheme.colorScheme.onSecondary,
                    disabledContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                ),
                modifier = Modifier.width(150.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                focusManager.clearFocus()
                viewModel.rollDice(diceRollState.bonus, diceRollState.penalty)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ) {
            Text(text = stringResource(R.string.textboxRoll))
        }
    }
}
