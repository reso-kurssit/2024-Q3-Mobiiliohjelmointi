package com.example.second.ui.screens.steam

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.second.ui.components.SwitchBackground
import com.example.second.data.model.NewsItem
import com.example.second.viewmodel.SteamViewModel
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.stringResource
import com.example.second.R
import com.example.second.ui.theme.LightestBrown

@Composable
fun SteamScreen(navController: NavController) {
    SwitchBackground()

    val viewModel: SteamViewModel = viewModel()
    val news = viewModel.news.value
    val loading = viewModel.loading.value
    val error = viewModel.error.value

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        if (loading) {
            Text(text = stringResource(R.string.textboxLoading), modifier = Modifier.padding(16.dp))
        } else if (error != null) {
            Text(text = stringResource(R.string.textboxError), modifier = Modifier.padding(16.dp))
        } else {
            for (newsItem in news) {
                val cleanContents = newsItem.contents.replace(Regex("<[^>]+>"), "")
                NewsResponse(newsItem.copy(contents = cleanContents))

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun NewsResponse(newsItem: NewsItem) {
    val semiTransparentColor = LightestBrown.copy(alpha = 0.7f)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(semiTransparentColor, RoundedCornerShape(8.dp))
            .padding(8.dp)
            .padding(bottom = 12.dp)
    ) {
        Text(
            text = newsItem.title,
            modifier = Modifier.padding(bottom = 4.dp),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = newsItem.contents,
            modifier = Modifier.padding(bottom = 4.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Divider()
    }
}
