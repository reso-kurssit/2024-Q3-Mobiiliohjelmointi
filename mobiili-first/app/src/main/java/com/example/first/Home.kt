package com.example.first

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
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

        Text (text = "Viikkotehtävien sijainnit", style = MaterialTheme.typography.titleLarge)

        Text (text = "- Viikko 1: Kuvankaappauksena Moodlessa", modifier = textModifier)

        Row(modifier = textModifier) {
            Text(text = "- Viikko 2: BMI -muunnin, ")
            Icon(Icons.Filled.Menu, contentDescription = "Menu Icon", modifier = Modifier.size(20.dp))
            Text(text = "-valikossa", modifier = Modifier.padding(start = 4.dp))
        }

        Row(modifier = textModifier) {
            Text(text = "- Viikko 3: Kirjautumislomake, ")
            Icon(Icons.Filled.Menu, contentDescription = "Menu Icon", modifier = Modifier.size(20.dp))
            Text(text = "-valikossa", modifier = Modifier.padding(start = 4.dp))
        }

        Text (text = "- Viikko 4: Teemat, integroitu sovellukseen", modifier = textModifier)

        Row(modifier = textModifier) {
            Text(text = "- Viikko 5: Kalorit -laskuri, ")
            Icon(Icons.Filled.Menu, contentDescription = "Menu Icon", modifier = Modifier.size(20.dp))
            Text(text = "-valikossa", modifier = Modifier.padding(start = 4.dp))
        }

        Text (text = "- Viikko 6: Scaffold -navigaatio, integroitu sovellukseen", modifier = textModifier)
        Text (text = "- Viikko 7: Tulossa", modifier = textModifier)
        Text (text = "- Viikko 8: Tulossa", modifier = textModifier)
        Text (text = "- Sovellusharjoitus: eri sovellus", modifier = textModifier)
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