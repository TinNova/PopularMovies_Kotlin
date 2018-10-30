package com.example.tinnovakovic.popularmovies_kotlin.ui.detail

import com.example.tinnovakovic.popularmovies_kotlin.data.Cast
import com.example.tinnovakovic.popularmovies_kotlin.data.Review
import com.example.tinnovakovic.popularmovies_kotlin.data.Trailer

class DetailContract {

    interface DetailView {

        fun showTrailers(trailer: Trailer)

        fun showCast(cast: Cast)

        fun showReviews(review: Review)

    }

    interface DetailPresenter {

        fun getMovieData(movieId: Int)
    }
}
