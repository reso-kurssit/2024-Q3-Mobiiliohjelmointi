package com.example.second.screens.diceroller

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random
import com.example.second.R

@Composable
fun DiceRollerScreen(navController: NavController) {
    var diceResult by remember { mutableStateOf(0) }
    var finalResult by remember { mutableStateOf(0) }
    var imageResource by remember { mutableStateOf(R.drawable.d201) }
    var bonus by remember { mutableStateOf(0) }
    var penalty by remember { mutableStateOf(0) }
    var specialMessageSuccess by remember { mutableStateOf("") }
    var specialMessageFailure by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
                painter = painterResource(id = imageResource),
                contentDescription = "D20 dice",
                modifier = Modifier.fillMaxSize()
            )

            Text(
                text = "$finalResult",
                fontSize = 32.sp,
                color = Color.White
            )
        }

        if (specialMessageSuccess.isNotEmpty()) {
            Text(text = specialMessageSuccess, color = Color.Green, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (specialMessageFailure.isNotEmpty()) {
            Text(text = specialMessageFailure, color = Color.Red, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            TextField(
                value = bonus.toString(),
                onValueChange = {
                    bonus = it.toIntOrNull() ?: 0
                },
                label = { Text(text = stringResource(R.string.textboxBonus)) },
                modifier = Modifier
                    .width(150.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            TextField(
                value = penalty.toString(),
                onValueChange = {
                    penalty = it.toIntOrNull() ?: 0
                },
                label = { Text(text = stringResource(R.string.textboxPenalty)) },
                modifier = Modifier.width(150.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

            diceResult = Random.nextInt(1, 21)

            val randomImage = Random.nextInt(201, 210)
            imageResource = when (randomImage) {
                201 -> R.drawable.d201
                202 -> R.drawable.d202
                203 -> R.drawable.d203
                204 -> R.drawable.d204
                205 -> R.drawable.d205
                206 -> R.drawable.d206
                207 -> R.drawable.d207
                208 -> R.drawable.d208
                209 -> R.drawable.d209
                else -> R.drawable.d201
            }

            if (diceResult == 20) {
                specialMessageSuccess = "Critical Success!"
                specialMessageFailure = ""
                finalResult = diceResult
            } else if (diceResult == 1) {
                specialMessageFailure = "Critical Failure!"
                specialMessageSuccess = ""
                finalResult = diceResult
            } else {
                finalResult = diceResult + bonus - penalty
                specialMessageSuccess = ""
                specialMessageFailure = ""
            }

            }) {
            Text(text = stringResource(R.string.textboxRoll))

        }
    }
}