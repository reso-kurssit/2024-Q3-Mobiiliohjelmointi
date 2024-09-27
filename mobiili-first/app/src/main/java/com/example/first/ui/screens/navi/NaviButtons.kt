package com.example.first.ui.screens.navi

import android.app.Activity
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.first.R
import com.example.first.ui.theme.QuiteDark
import com.example.first.ui.theme.SolidBlue

val topBarBackground = QuiteDark
val customFont = FontFamily(
    Font(R.font.dancingscript)
)

@Composable
fun NaviButtons(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val activity = context as? Activity

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer)
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
                Icon(Icons.Filled.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(36.dp),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }

            Text(
                text = stringResource(R.string.titleApp),
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 28.dp)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontFamily = customFont,
                fontSize = 36.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )

            Box(modifier = Modifier.size(36.dp))
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {

            DropdownMenuItem(
                { Text(text = stringResource(R.string.main), color = SolidBlue) },
                onClick = { navController.navigate("home")
                expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = stringResource(R.string.week2), color = SolidBlue) },
                onClick = { navController.navigate("bmi")
                    expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = stringResource(R.string.week3), color = SolidBlue) },
                onClick = { navController.navigate("loginform")
                    expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = stringResource(R.string.week4), color = SolidBlue) },
                onClick = { navController.navigate("buttons")
                    expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = stringResource(R.string.week5), color = SolidBlue) },
                onClick = { navController.navigate("calories")
                    expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = stringResource(R.string.week6), color = SolidBlue) },
                onClick = { navController.navigate("scaff")
                    expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = stringResource(R.string.week7), color = SolidBlue) },
                onClick = { navController.navigate("bmiviewmodel")
                    expanded = false
                }
            )

            DropdownMenuItem(
                { Text(text = stringResource(R.string.week8), color = SolidBlue) },
                onClick = { navController.navigate("randomTodos")
                    expanded = false
                }
            )

        }

       }
    }