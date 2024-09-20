package com.example.second.data.network

import com.example.second.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SteamApi {
    @GET("ISteamNews/GetNewsForApp/v0002/")
    suspend fun getNewsForApp(
        @Query("appid") appId: Int,
        @Query("count") count: Int,
        @Query("maxlength") maxLength: Int,
        @Query("format") format: String = "json"
    ): NewsResponse
}