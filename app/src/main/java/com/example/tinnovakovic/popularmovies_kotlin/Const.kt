package com.example.tinnovakovic.popularmovies_kotlin

object Const {

    //const means that only one instance of the String is created in compile time,
    //instead of a new one created for every class it's used in.
    const val API_KEY = "41fe79dd1f576ae823dfb4939a5eaff6"
    const val BASE_URL = "https://api.themoviedb.org/"
    const val BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w342/"

    const val MOVIE_POSTER = "MoviePoster"
    const val MOVIE_TITLE = "MovieTitle"
    const val MOVIE_SYNOPSIS = "MovieSynopsis"
    const val MOVIE_RATING = "MovieRating"
    const val MOVIE_RELEASE_DATE = "MovieReleaseDate"
    const val MOVIE_ID = "MovieId"

    const val DEFAULT_VALUE = -99

    const val YOUTUBE_THUMBNAIL_BASE_URL = "https://img.youtube.com/vi/"
    const val YOUTUBE_THUMBNAIL_END_URL = "/0.jpg"
    const val YOUTUBE_TRAILER_BASE_URL = "https://www.youtube.com/watch?v="

}