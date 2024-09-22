package com.example.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.first.ui.theme.FirstTheme
import com.example.first.screens.bmi.Bmi
import com.example.first.screens.bottom.CustomBottomAppBar
import com.example.first.screens.loginform.LoginForm
import com.example.first.screens.calories.CalorieScreen
import com.example.first.screens.home.Home
import com.example.first.screens.navi.NaviButtons
import com.example.first.screens.theming.ColorSwitchingButtons

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
            topBar = { NaviButtons(navController) } ,

            bottomBar = { CustomBottomAppBar(navController) }

        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                composable("home") { Home(navController) }
                composable("bmi") { Bmi(navController) }
                composable("loginform") { LoginForm(navController) }
                composable("buttons") { ColorSwitchingButtons(navController) }
                composable("calories") { CalorieScreen(navController) }
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
