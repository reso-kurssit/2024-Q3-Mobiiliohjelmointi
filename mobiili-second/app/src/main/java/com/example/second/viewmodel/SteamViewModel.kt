package com.example.second.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.second.data.model.NewsItem
import com.example.second.data.repository.SteamRepository
import kotlinx.coroutines.launch

class SteamViewModel : ViewModel() {
    private val repository = SteamRepository()
    val news = mutableStateOf<List<NewsItem>>(emptyList())
    val loading = mutableStateOf(true)
    val error = mutableStateOf<String?>(null)

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                news.value = repository.fetchNews(1086940, 4, 200)
            } catch (e: Exception) {
                Log.e("SteamViewModel", "Error fetching news", e)
                error.value = "Failed to fetch news: ${e.message}"
            } finally {
                loading.value = false
            }
        }
    }
}