package com.example.tinnovakovic.popularmovies_kotlin.ui

import com.example.tinnovakovic.popularmovies_kotlin.data.Movie
import com.example.tinnovakovic.popularmovies_kotlin.data.MovieResult

class MainContract {

    interface MainView {

        fun showData(movieResult: List<MovieResult>)

    }

    interface MainPresenter {

        fun getMovies(popularFilms: Boolean)
    }
}