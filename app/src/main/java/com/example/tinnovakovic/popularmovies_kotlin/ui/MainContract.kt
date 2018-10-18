package com.example.tinnovakovic.popularmovies_kotlin.ui

import com.example.tinnovakovic.popularmovies_kotlin.data.Movie

class MainContract {

    interface MainView {

        fun showData(movie: Movie)
    }

    interface MainPresenter {

        fun getMovies(popularFilms: Boolean)
    }
}