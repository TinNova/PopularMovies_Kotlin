package com.example.tinnovakovic.popularmovies_kotlin.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tinnovakovic.popularmovies_kotlin.Const
import com.example.tinnovakovic.popularmovies_kotlin.Const.DEFAULT_VALUE
import com.example.tinnovakovic.popularmovies_kotlin.Const.MOVIE_ID
import com.example.tinnovakovic.popularmovies_kotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailContract.DetailView {

    private lateinit var presenter: DetailPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter = DetailPresenter(this)
        setupView()
    }

    private fun setupView() {

        if (intent.hasExtra(MOVIE_ID)) {

            val moviePoster = intent.getStringExtra(Const.MOVIE_POSTER)
            val movieTitle = intent.getStringExtra(Const.MOVIE_TITLE)
            val movieSynopsis = intent.getStringExtra(Const.MOVIE_SYNOPSIS)
            val movieRating = intent.getStringExtra(Const.MOVIE_RATING)
            val movieReleaseDate = intent.getStringExtra(Const.MOVIE_RELEASE_DATE)
            val movieId = intent.getIntExtra(Const.MOVIE_ID, DEFAULT_VALUE)

            Picasso.with(this).load(moviePoster).into(movie_image)
            movie_title.text = movieTitle
            synopsis_text.text = movieSynopsis
            rating_text.text = movieRating
            movie_release_date.text = movieReleaseDate

            /** Use RxJava zip operator to get all three together */
//            presenter.getTrailerCastReviews(movieId)

        } else {
            Log.d("DetailActivity", "Error, nothing passed in Intent")
        }
    }
}
