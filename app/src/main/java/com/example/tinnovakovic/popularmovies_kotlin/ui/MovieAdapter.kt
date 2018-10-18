package com.example.tinnovakovic.popularmovies_kotlin.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tinnovakovic.popularmovies_kotlin.Const.BASE_IMAGE_URL
import com.example.tinnovakovic.popularmovies_kotlin.R
import com.example.tinnovakovic.popularmovies_kotlin.data.MovieResult
import com.example.tinnovakovic.popularmovies_kotlin.ui.MovieAdapter.ViewHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movies_list_item.view.*

class MovieAdapter(private val movieResults : List<MovieResult>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.movies_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.with(context)
                .load(BASE_IMAGE_URL + movieResults[position].posterPath)
                .into(holder.imageView)
    }

    override fun getItemCount(): Int = movieResults.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.main_movie_image
    }
}