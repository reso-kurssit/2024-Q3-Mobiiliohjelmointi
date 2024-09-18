package com.example.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NaviButtons(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .background(Color.LightGray)
            .drawBehind {
                drawLine(
                    color = Color.Black,
                    strokeWidth = 4f,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height)
                )
            }
            .padding(16.dp)

    ) {

        Column(modifier = Modifier.run { padding(top = 28.dp).padding(horizontal = 20.dp) }) {
            Text("Viikkotehtävät")
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.padding(top = 2.dp).padding(horizontal = 22.dp)
            ) {

                Button(onClick = {
                    navController.navigate("bmi")
                }, modifier = Modifier.padding(end = 8.dp)) {
                    Text(text = "2")
                }

                Button(onClick = {
                    navController.navigate("loginform")
                }) {
                    Text(text = "3")
                }
            }
        }
    }

}
