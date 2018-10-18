package com.example.tinnovakovic.popularmovies_kotlin.ui

import com.example.tinnovakovic.popularmovies_kotlin.data.MovieResult

interface MoviePositionListener {

    fun movieItemClick(movie: MovieResult)

}