package com.example.a203110017_annisakinanti.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a203110017_annisakinanti.R
import com.example.a203110017_annisakinanti.adapter.NewsListAdapter
import com.example.a203110017_annisakinanti.viewmodel.NewsHeadlineActivityViewModel
import kotlinx.android.synthetic.main.activity_news_headline.*

// TODO 9: Kelas Activity untuk menyajikan data ke user
class NewsHeadlineActivity : AppCompatActivity() {

    // inisialiasi viewmodel berita
    private lateinit var newsHeadlineViewModel: NewsHeadlineActivityViewModel

    // inisialiasi adapter berita
    private lateinit var newsAdapter: NewsListAdapter

    // menghubungkan ke activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_headline)

        // mengembalikan viewmodel
        newsHeadlineViewModel =
            ViewModelProvider(this).get(NewsHeadlineActivityViewModel::class.java)

        newsHeadlineViewModel.getNewsHeadlineList()
        newsHeadlineViewModel.showProgress.observe(this, Observer {
            if (it) {
                //TODO
            }
        })

        // AdapterView adalah ViewGroup yang menampilkan item yang dimuat ke dalam adaptor.
        // Jenis adaptor yang paling umum berasal dari sumber data berbasis array.
        newsAdapter = NewsListAdapter(this)
        recycler_news.adapter = newsAdapter
        recycler_news.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.HORIZONTAL
            )
        )

        newsHeadlineViewModel.newsList.observe(this, Observer {
            newsAdapter.setNewsList(it)
        })

    }
}