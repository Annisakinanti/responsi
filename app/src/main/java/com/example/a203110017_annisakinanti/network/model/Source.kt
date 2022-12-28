package com.example.a203110017_annisakinanti.network.model

import com.google.gson.annotations.SerializedName

// TODO 2: Kelas Model untuk data 'Source'
data class Source(
    @field:SerializedName("id") val id: String?,
    @field:SerializedName("name") val sourceName: String
)