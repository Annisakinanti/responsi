package com.example.a203110017_annisakinanti.network.model

import com.google.gson.annotations.SerializedName

// TODO 4: Kelas Model untuk  data 'Articles'
data class Articles(
    @field:SerializedName("source") val source: Source,
    @field:SerializedName("author") val author: String,
    @field:SerializedName("title") val title: String,
    @field:SerializedName("description") val description: String,
    @field:SerializedName("url") val url: String,
    @field:SerializedName("urlToImage") val urlToImage: String,
    @field:SerializedName("publishedAt") val publishedAt: String,
    @field:SerializedName("content") val content: String?
)