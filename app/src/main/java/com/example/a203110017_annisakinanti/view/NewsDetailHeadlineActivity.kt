package com.example.a203110017_annisakinanti.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.a203110017_annisakinanti.R
import com.example.a203110017_annisakinanti.network.model.Articles
import com.example.a203110017_annisakinanti.viewmodel.NewsDetailHeadlineActivityViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_news_detail_headline.*

// TODO 10: Kelas activity untuk menampilkan detail berita
class NewsDetailHeadlineActivity : AppCompatActivity() {

    private lateinit var articles: Articles
    private lateinit var newsDetailHeadlineViewModel: NewsDetailHeadlineActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail_headline)

        val jsonArticles: String
        val extras = intent.extras
        if (extras != null) {
            jsonArticles = extras.getString("articles").toString()
            articles = Gson().fromJson(jsonArticles, Articles::class.java)
        }

        newsDetailHeadlineViewModel =
            ViewModelProvider(this).get(NewsDetailHeadlineActivityViewModel::class.java)
        if (savedInstanceState == null) {
            newsDetailHeadlineViewModel.getNewsDetailHeadline(articles)
        }

        newsDetailHeadlineViewModel.newsDetails.observe(this, Observer {
            setNewsDetail(it)
        })
    }

    private fun setNewsDetail(it: Articles?) {

        txt_headline_title.text = articles.title

        Glide.with(this)
            .load(articles.urlToImage)
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .fallback(R.drawable.placeholder)
            .into(img_news)

        txt_headline_desc.text = articles.description

    }
}