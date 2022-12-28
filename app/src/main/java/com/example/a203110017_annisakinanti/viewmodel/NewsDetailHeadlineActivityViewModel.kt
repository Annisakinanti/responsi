package com.example.a203110017_annisakinanti.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.a203110017_annisakinanti.network.model.Articles
import com.example.a203110017_annisakinanti.repository.NewsDetailHeadlineActivityRepository

// TODO 9: Kelas ViewModel untuk menangani UI Detail Berita
class NewsDetailHeadlineActivityViewModel(application: Application) :
    AndroidViewModel(application) {

    private val newsDetailHeadlineRepository = NewsDetailHeadlineActivityRepository(application)

    // Menyimpan list data
    val newsDetails: LiveData<Articles>


    // Inisiaslasi kelas repositori
    init {
        this.newsDetails = newsDetailHeadlineRepository.newsDetails
    }


    // mengembalil data berita
    fun getNewsDetailHeadline(articles: Articles) {
        newsDetailHeadlineRepository.getNewsDetailHeadline(articles)
    }
}