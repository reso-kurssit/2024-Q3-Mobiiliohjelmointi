package com.example.second

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.second.ui.theme.FirstTheme
import com.example.second.screens.home.Home
import com.example.second.screens.navi.Navi
import com.example.second.screens.steam.SteamScreen
import com.example.second.screens.diceroller.DiceRollerScreen
import com.example.second.ui.theme.SolidBlue

class MainActivity : ComponentActivity() {

    val bottomBarBackground = SolidBlue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FirstTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()

        Scaffold(
            topBar = { Navi(navController) },
            bottomBar = {
                BottomAppBar {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(bottomBarBackground)
                            .padding(2.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.textboxBottomBar),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                Modifier.padding(innerPadding)
            ) {
                composable("home") { Home(navController) }
                composable("steam") { SteamScreen(navController) }
                composable("dice") { DiceRollerScreen(navController) }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        FirstTheme {
            MainScreen()
        }
    }
}
