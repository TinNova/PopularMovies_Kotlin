package com.example.tinnovakovic.popularmovies_kotlin.ui

import com.example.tinnovakovic.popularmovies_kotlin.Movie

class MainContract {

    interface MainView {

        fun showData(movies: Movie)

    }

    interface MainPresenter {

        fun getMovies(popularFilms: Boolean)
    }
}