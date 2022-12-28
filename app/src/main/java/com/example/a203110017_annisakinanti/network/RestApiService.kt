package com.example.a203110017_annisakinanti.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO 0: Kelas retrofit untuk terhububung ke web service
object RestApiService {
    // URL yang dituju
    const val API_BASE_URL = "https://newsapi.org/"
    // token user
    const val token = "21e3e39250904c5881a3bf9bc085d20b"
    const val country = "id"

//    Proses membangun retrofit untuk ambil data dari web service
    private val retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // membuat kelas create service untuk retrofit
    fun <S> createService(serviceClass: Class<S>?): S {
        return retrofit.create(serviceClass)
    }
}
