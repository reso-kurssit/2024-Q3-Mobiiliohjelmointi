package com.example.second

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.second.screens.bottom.CustomBottomAppBar
import com.example.second.ui.theme.FirstTheme
import com.example.second.screens.home.Home
import com.example.second.screens.navi.Navi
import com.example.second.screens.steam.SteamScreen
import com.example.second.screens.diceroller.DiceRollerScreen

class MainActivity : ComponentActivity() {

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
            bottomBar = { CustomBottomAppBar(navController) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                Modifier
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.surface)
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