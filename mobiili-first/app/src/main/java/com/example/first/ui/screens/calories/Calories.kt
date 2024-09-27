package com.example.first.ui.screens.calories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.first.ui.theme.FirstTheme
import androidx.compose.ui.text.font.FontWeight


@Composable
fun CalorieScreen(navController: NavController) {
    var weightInput by remember { mutableStateOf("") }
    var weight = weightInput.toIntOrNull() ?: 0
    var ifTrueMaleIfFalseFemale by remember { mutableStateOf( true) }
    var intensity by remember { mutableStateOf(1.3f) }
    var result by remember { mutableStateOf(0) }

    val reusableModifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)

    val textStyle = MaterialTheme.typography.bodyLarge.copy(
        color = MaterialTheme.colorScheme.onSecondaryContainer
    )

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Heading(title = stringResource(R.string.titleWeek5))
        WeightField(weightInput = weightInput, onValueChange = { weightInput = it }, textStyle = textStyle)
        GenderChoice(ifTrueMaleIfFalseFemale, setGender = { ifTrueMaleIfFalseFemale = it}, textStyle = textStyle)
        IntensityList(onClick = {intensity = it}, textStyle = textStyle)
        Text (
            text = result.toString(),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            fontWeight = FontWeight.Bold,
            style = textStyle
        )
        Calculation(ifTrueMaleIfFalseFemale = ifTrueMaleIfFalseFemale, weight = weight, intensity = intensity, setResult = {result = it})
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
fun WeightField (weightInput: String, onValueChange: (String) -> Unit, textStyle: TextStyle) {
    OutlinedTextField(
        value = weightInput,
        onValueChange = onValueChange,
        label = { Text(text = "Enter weight") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth(),
        textStyle = textStyle
    )
}

@Composable
fun GenderChoice (
    ifTrueMaleIfFalseFemale: Boolean,
    setGender: (Boolean) -> Unit,
    textStyle: TextStyle
) {
    Column (Modifier.selectableGroup()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton (
                selected = ifTrueMaleIfFalseFemale,
                onClick = {setGender(true)}
            )
            Text(text = "Male", style = textStyle)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = !ifTrueMaleIfFalseFemale,
                onClick = { setGender(false) })
            Text (text = "Female", style = textStyle)
        }
    }
}

@Composable
fun IntensityList (onClick: (Float) -> Unit, textStyle: TextStyle) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Light") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val items = listOf("Light", "Usual", "Moderate", "Hard", "Very hard")

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column {
        OutlinedTextField(
            readOnly = true,
            value = selectedText,
            onValueChange = { selectedText = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates -> textFieldSize = coordinates.size.toSize() },
            label = { Text(text = stringResource(R.string.selected))},
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            },
            textStyle = textStyle
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textFieldSize.width.toDp()})
            ) {
            items.forEach { label ->

                Text(
                    text = label,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedText = label

                            val intensity: Float = when (label) {
                                "Light" -> 1.3f
                                "Usual" -> 1.5f
                                "Moderate" -> 1.7f
                                "Hard" -> 2f
                                "Very hard" -> 2.2f
                                else -> 0.0f
                            }
                            onClick(intensity)
                            expanded = false
                        }
                        .padding(8.dp),
                    style = textStyle
                )
            }
        }
    }
}

@Composable
fun Calculation (ifTrueMaleIfFalseFemale: Boolean, weight: Int, intensity: Float, setResult: (Int) -> Unit) {
    Button (
        onClick = {
            if (ifTrueMaleIfFalseFemale) {
                setResult(((879 + 10.2 * weight) * intensity).toInt())
            } else {
                setResult(((795 + 7.18 * weight) * intensity).toInt())
            }
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text (text = stringResource(R.string.calculate))
    }
}