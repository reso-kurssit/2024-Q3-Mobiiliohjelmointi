package com.example.first.exercises.calories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.first.ui.theme.FirstTheme


@Composable
fun CalorieScreen(navController: NavController) {
    var weightInput by remember { mutableStateOf("") }
    var ifTrueMaleIfFalseFemale by remember { mutableStateOf( true) }
    var password: String by remember { mutableStateOf("") }

    val reusableModifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Heading(title = stringResource(R.string.titleWeek5))
        WeightField(weightInput = weightInput, onValueChange = { weightInput = it })
        GenderChoice(ifTrueMaleIfFalseFemale, setGender = { ifTrueMaleIfFalseFemale = it})
    }
}

@Composable
fun DefaultPreview() {
    FirstTheme {
        CalorieScreen(navController = NavController(LocalContext.current))
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
fun WeightField (weightInput: String, onValueChange:(String) -> Unit) {
    OutlinedTextField(
        value = weightInput,
        onValueChange = onValueChange,
        label = { Text(text = "Enter weight") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )

}

@Composable
fun GenderChoice (ifTrueMaleIfFalseFemale: Boolean, setGender:(Boolean) -> Unit) {
    Column (Modifier.selectableGroup()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton (
                selected = ifTrueMaleIfFalseFemale,
                onClick = {setGender(true)}
            )
            Text(text = "Male")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = !ifTrueMaleIfFalseFemale,
                onClick = { setGender(false) })
            Text (text = "Female")
        }

    }
}