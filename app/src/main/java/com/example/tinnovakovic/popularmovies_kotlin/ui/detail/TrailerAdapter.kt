package com.example.tinnovakovic.popularmovies_kotlin.ui.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tinnovakovic.popularmovies_kotlin.Const.YOUTUBE_THUMBNAIL_BASE_URL
import com.example.tinnovakovic.popularmovies_kotlin.Const.YOUTUBE_THUMBNAIL_END_URL
import com.example.tinnovakovic.popularmovies_kotlin.R
import com.example.tinnovakovic.popularmovies_kotlin.data.TrailerResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.trailer_list_item.view.*

class TrailerAdapter(val trailerClickCallback: (TrailerResult) -> Unit) : RecyclerView.Adapter<TrailerAdapter.TrailerHolder>() {

    private var trailerData: List<TrailerResult> = listOf()

    override fun getItemCount(): Int = trailerData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerAdapter.TrailerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trailer_list_item, parent, false)
        return TrailerHolder(view)
    }

    override fun onBindViewHolder(holder: TrailerAdapter.TrailerHolder, position: Int) {
        holder.bind(trailerData[position])
        holder.itemView.setOnClickListener { trailerClickCallback(trailerData[position]) }
    }

    fun setData(data: List<TrailerResult>) {
        trailerData = data
        notifyDataSetChanged()
    }

    class TrailerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(trailer: TrailerResult) {
            Picasso.with(itemView.context)
                    .load(YOUTUBE_THUMBNAIL_BASE_URL + trailer.key + YOUTUBE_THUMBNAIL_END_URL)
                    .into(itemView.trailerThumbnail)

            itemView.trailerTitle.text = trailer.name
        }
    }
}
