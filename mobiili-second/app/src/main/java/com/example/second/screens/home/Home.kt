package com.example.second.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.second.R
import com.example.second.components.SwitchBackground
import com.example.second.ui.theme.FirstTheme
import com.example.second.ui.theme.LightestBrown

@Composable
fun Home(navController: NavController) {

    SwitchBackground()

    val semiTransparentColor = LightestBrown.copy(alpha = 0.7f)
    val textModifier = Modifier
        .padding(horizontal = 12.dp)

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Box(
            modifier = Modifier
                .padding(8.dp)
                .background(semiTransparentColor, RoundedCornerShape(8.dp))
                .padding(2.dp)
        ) {
            Heading(title = stringResource(R.string.titleHome))
        }

        Row(modifier = textModifier
            .background(semiTransparentColor, RoundedCornerShape(8.dp))
            .padding(all = 9.dp)
            .fillMaxWidth()) {
            Text(text = stringResource(R.string.textboxHome))
            Icon(Icons.Filled.Menu, contentDescription = "Menu Icon", modifier = Modifier.size(20.dp))
        }
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