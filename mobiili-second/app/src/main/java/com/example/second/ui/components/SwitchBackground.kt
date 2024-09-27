package com.example.second.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay

import com.example.second.R;

@Composable
fun SwitchBackground() {
    val images = listOf(
        painterResource(id = R.drawable.background1),
        painterResource(id = R.drawable.background2),
        painterResource(id = R.drawable.background3)
    )

    var currentImageIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(9000)
            currentImageIndex = (currentImageIndex + 1) % images.size
        }
    }

    Image(
        painter = images[currentImageIndex],
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}