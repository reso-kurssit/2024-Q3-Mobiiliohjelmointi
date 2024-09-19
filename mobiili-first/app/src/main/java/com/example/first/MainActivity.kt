package com.example.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.first.ui.theme.FirstTheme
import com.example.first.exercises.bmi.Bmi
import com.example.first.exercises.loginform.LoginForm
import com.example.first.exercises.calories.CalorieScreen


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
            topBar = { NaviButtons(navController) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                Modifier.padding(innerPadding)
            ) {
                composable("home") { Home(navController) }
                composable("bmi") { Bmi(navController) }
                composable("loginform") { LoginForm(navController) }
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
