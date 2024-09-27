package com.example.second.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.second.ui.screens.bottom.CustomBottomAppBar
import com.example.second.ui.theme.FirstTheme
import com.example.second.ui.screens.home.Home
import com.example.second.ui.screens.navi.Navi
import com.example.second.ui.screens.steam.SteamScreen
import com.example.second.ui.screens.diceroller.DiceRollerScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.second.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FirstTheme {
                val mainViewModel: MainViewModel = viewModel()

                mainViewModel.simulateLoading()
                MainScreen(mainViewModel)
            }
        }
    }

    @Composable
    fun MainScreen(mainViewModel: MainViewModel) {
        val navController = rememberNavController()
        val isLoading by mainViewModel.isLoading.collectAsState()

        Scaffold(
            topBar = { Navi(navController, mainViewModel) },
            bottomBar = { CustomBottomAppBar(navController) }
        ) { innerPadding ->
            if (isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
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
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        FirstTheme {
            val mainViewModel: MainViewModel = MainViewModel()
            MainScreen(mainViewModel)
        }
    }
}