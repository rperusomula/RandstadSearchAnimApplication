package com.example.randstadsearchanimapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.randstadsearchanimapplication.R
import com.example.randstadsearchanimapplication.model.AnimeItem
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class SearchAnimeAdapter(
    private val animeList: List<AnimeItem?>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class SearchAnimeAdapter(view: View) : ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchAnimeAdapter(
            LayoutInflater.from(parent.context).inflate(R.layout.search_anime_item_details, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SearchAnimeAdapter) {
            holder.bindView(position, animeList)
        }
    }

    open inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(
            position: Int,
            listOfAnimes: List<AnimeItem?>?
        ) {
            itemView.apply {
                listOfAnimes?.let {
                    if (position >= 0) {
                        it.get(position)?.let { animItem ->
                            val builder = Picasso.Builder(context)
                            builder.downloader(OkHttp3Downloader(context))
                            builder.build().load(animItem.image_url)
                                .into(findViewById<ImageView>(R.id.anime_image))
                            findViewById<AppCompatTextView>(R.id.anime_title).text = animItem.title
                            findViewById<AppCompatTextView>(R.id.anime_synopsis).text = animItem.synopsis

                        }
                    }
                }
            }
        }
    }
}