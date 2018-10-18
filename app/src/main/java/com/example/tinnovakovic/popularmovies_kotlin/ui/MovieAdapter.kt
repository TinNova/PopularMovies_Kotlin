package com.example.tinnovakovic.popularmovies_kotlin.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tinnovakovic.popularmovies_kotlin.Const.BASE_IMAGE_URL
import com.example.tinnovakovic.popularmovies_kotlin.data.MovieResult
import kotlinx.android.synthetic.main.movies_list_item.view.*

//class MovieAdapter(private val movieResults: List<MovieResult>,
//                   private val context: Context,
//                   private val clickListener: (MovieResult) -> Unit)
//    : RecyclerView.Adapter<ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(LayoutInflater.from(context)
//                .inflate(R.layout.movies_list_item, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(
//                Picasso.with(context)
//                .load(BASE_IMAGE_URL + movieResults[position].posterPath)
//                .into(holder.itemView.main_movie_image), clickListener)
//
//    }
//
//    override fun getItemCount(): Int = movieResults.size
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
////        val imageView = itemView.main_movie_image
//
//        fun bind(movie: MovieResult, clickListener: (MovieResult) -> Unit) {
//            itemView.main_movie_image = movie.posterPath
//            itemView.setOnClickListener { clickListener(movie)}
//        }
//    }
//}

class MovieAdapter(val movieClickCallback: (MovieResult) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    private var movieData: List<MovieResult> = listOf()

    override fun getItemCount(): Int = movieData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder =
            MovieHolder(
                    ItemMovieBinding.inflate(
                            LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieData[position])
        holder.itemView.setOnClickListener { movieClickCallback(movieData[position]) }
    }

    fun setData(data: List<MovieResult>) {
        movieData = data
        notifyDataSetChanged()
    }

    class MovieHolder constructor(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie : MovieResult) {
            binding.movie = movie

            with(itemView) {
                movieImage.loadWithGlide(BASE_IMAGE_URL + movie.posterPath)
            }
        }
    }
}
