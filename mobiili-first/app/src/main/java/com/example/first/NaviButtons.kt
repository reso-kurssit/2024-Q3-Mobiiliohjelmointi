package com.example.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import com.example.first.ui.theme.SolidBlue
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

val customFont = FontFamily(
    Font(R.font.dancingscript)
)

@Composable
fun NaviButtons(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .background(Color.LightGray)
            .padding(16.dp),
        contentAlignment = Alignment.Center

    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = {expanded = true},
                modifier = Modifier.padding(top = 16.dp)) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu",
                    modifier = Modifier
                        .size(36.dp)
                )
            }

            Text(
                text = "Fancy Äppi",
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 28.dp)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontFamily = customFont,
                fontSize = 36.sp
            )

            Box(modifier = Modifier.size(36.dp))
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }) {

            DropdownMenuItem(
                { Text(text = "Alku", color = SolidBlue) },
                onClick = { navController.navigate("home")
                expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = "Viikko 2", color = SolidBlue) },
                onClick = { navController.navigate("bmi")
                    expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = "Viikko 3", color = SolidBlue) },
                onClick = { navController.navigate("loginform")
                    expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = "Viikko 5", color = SolidBlue) },
                onClick = { navController.navigate("calories")
                    expanded = false
                }
            )

        }

       }
    }





