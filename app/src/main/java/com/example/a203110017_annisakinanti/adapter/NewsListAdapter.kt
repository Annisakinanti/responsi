package com.example.a203110017_annisakinanti.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a203110017_annisakinanti.R
import com.example.a203110017_annisakinanti.network.model.Articles
import com.example.a203110017_annisakinanti.util.AppUtils
import com.example.a203110017_annisakinanti.view.NewsDetailHeadlineActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.row_item_feed.view.*

// TODO 7: Kelas Adapter untuk meneruskan data ke UI
class NewsListAdapter(private val context: Context) :
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    // Inisiaslisasi list Articles
    private var list: List<Articles> = ArrayList<Articles>()

    // Menghungkan ke activity row_item_feed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_item_feed, parent, false)
        return NewsViewHolder(view, context)
    }

    override fun getItemCount(): Int = list.size

    // Melakukan binding ke adapter
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article: Articles = list[position]
        holder.bind(article)
    }

    fun setNewsList(list: List<Articles>?) {
        if (list != null) {
            this.list = list
        }
        notifyDataSetChanged()
    }

    // ViewHolder untuk proses wrapper diView yang berisi layout untuk setiap item dalam list.
    class NewsViewHolder(itemView: View, context: Context) :
        RecyclerView.ViewHolder(itemView) {

        // cek apakah list bernilai null
        private var articles: Articles? = null

        // proses inisialiasi data articles    dan inten ke activity
        init {
            itemView.setOnClickListener {
                articles.let {
                    val intent = Intent(context, NewsDetailHeadlineActivity::class.java)
                    intent.putExtra("articles", Gson().toJson(articles))
                    context.startActivity(intent)
                }
            }

        }

        // proses binding untuk meneruskan data ke activity
        fun bind(articles: Articles) {
            this.articles = articles
            itemView.txt_headline_title.text = articles.title

            val resources = this.itemView.context.resources
            itemView.txt_news_source_date.text = String.format(
                resources.getString(R.string.item_source_date),
                articles.source.sourceName,
                AppUtils.getDate(articles.publishedAt),
                AppUtils.getTime(articles.publishedAt)
            )

            // glide untuk memuat image ke activity
            Glide.with(itemView)
                .load(articles.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .fallback(R.drawable.placeholder)
                .into(itemView.img_news)

        }
    }
}