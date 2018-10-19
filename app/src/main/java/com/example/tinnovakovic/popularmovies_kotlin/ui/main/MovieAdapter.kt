package com.example.tinnovakovic.popularmovies_kotlin.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tinnovakovic.popularmovies_kotlin.Const.BASE_IMAGE_URL
import com.example.tinnovakovic.popularmovies_kotlin.R
import com.example.tinnovakovic.popularmovies_kotlin.data.MovieResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movies_list_item.view.*

class MovieAdapter(val movieClickCallback: (MovieResult) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    private var movieData: List<MovieResult> = listOf()

    override fun getItemCount(): Int = movieData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movies_list_item, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieData[position])
        holder.itemView.setOnClickListener { movieClickCallback(movieData[position]) }
        holder.itemView.movieImage.setOnClickListener { }
    }

    fun setData(data: List<MovieResult>) {
        movieData = data
        notifyDataSetChanged()
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: MovieResult) {
            Picasso.with(itemView.context)
                    .load(BASE_IMAGE_URL + movie.posterPath)
                    .into(itemView.movieImage)
        }
    }
}
