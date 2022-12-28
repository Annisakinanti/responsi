package com.example.a203110017_annisakinanti.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.a203110017_annisakinanti.network.model.Articles
import com.example.a203110017_annisakinanti.repository.NewsHeadlineActivityRepository

// TODO 8: Kelas ViewModel untuk menangani UI daftar berita
class NewsHeadlineActivityViewModel(application: Application) : AndroidViewModel(application) {

    // mengisialialiasi kelas reposity
    private val newsHeadlineRepository = NewsHeadlineActivityRepository(application)

    // memproses data progress bar
    val showProgress: LiveData<Boolean>

    // memprores data berita
    val newsList: LiveData<List<Articles>>

    // melakukan inisiasliasi variabel tersebut terhadap repository
    init {
        this.showProgress = newsHeadlineRepository.showProgress
        this.newsList = newsHeadlineRepository.newsList
    }

    fun changeProgressState() {
        newsHeadlineRepository.changeProgressState()
    }

    // mengambil list data berita
    fun getNewsHeadlineList() {
        newsHeadlineRepository.getNewsHeadlineList()
    }
}

