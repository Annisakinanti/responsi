package com.example.a203110017_annisakinanti.network

import com.example.a203110017_annisakinanti.network.model.NewsFeed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// TODO 1: Kelas untuk mengambil data dari internet
interface NewsHeadlinesApi {
//    Melakukan request end point terhadap data
    @GET("v2/top-headlines")
    suspend fun getNewsHeadlineList(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsFeed>
}