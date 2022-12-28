package com.example.a203110017_annisakinanti.network.model

import com.google.gson.annotations.SerializedName
// TODO 3: Kelas Model untuk  data 'NewsFeed'
data class NewsFeed(
    @field:SerializedName("status") val status: String,
    @field:SerializedName("totalResults") val totalResults: Int,
    @field:SerializedName("articles") val articles: ArrayList<Articles> = ArrayList<Articles>()
)
