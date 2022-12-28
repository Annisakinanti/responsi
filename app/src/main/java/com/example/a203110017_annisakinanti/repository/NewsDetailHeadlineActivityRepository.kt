package com.example.a203110017_annisakinanti.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.a203110017_annisakinanti.network.model.Articles

// TODO 6: Kelas repository untuk mengisolasi sumber data/ model
class NewsDetailHeadlineActivityRepository(val application: Application) {

    // inisialasasi list data dari model Articles
    val newsDetails = MutableLiveData<Articles>()

    // mengambal list data dari model Articles
    fun getNewsDetailHeadline(newsDetail: Articles) {
        newsDetails.value = newsDetail
    }

}

