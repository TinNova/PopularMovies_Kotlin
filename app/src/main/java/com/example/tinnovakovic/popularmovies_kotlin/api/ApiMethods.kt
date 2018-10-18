package com.example.tinnovakovic.popularmovies_kotlin.api

import com.example.tinnovakovic.popularmovies_kotlin.data.Movie
import com.example.tinnovakovic.popularmovies_kotlin.data.MovieResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMethods {

    /**
     * The Top Rated Feed
     * "https://api.themoviedb.org/3/movie/top_rated?api_key=41fe79dd1f576ae823dfb4939a5eaff6&language=en-UK&page=1"
     * The Popular Feed
     * "https://api.themoviedb.org/3/movie/popular?api_key={{API_KEY}}&language=en-UK&page=1"
     * The Trailers Feed
     * "https://api.themoviedb.org/3/movie/{{MOVIE_ID}}/videos?api_key={{API_KEY}}&language=en-UK"
     * The Cast Members Feed (Credits)
     * "https://api.themoviedb.org/3/movie/339403/credits?api_key={{API_KEY}}&language=en-UK"
     * The Reviews Feed
     * "https://api.themoviedb.org/3/movie/339403/reviews?api_key={{API_KEY}}&language=en-US"
     * The GetDetail Feed
     * "https://api.themoviedb.org/3/movie/339403?api_key=41fe79dd1f576ae823dfb4939a5eaff6&language=en-UK"
     */

    @GET("3/movie/top_rated?language=en-UK&page=1")
    fun getTopRatedFilms(@Query("api_key") apiKey: String): Single<List<MovieResult>>

    @GET("3/movie/popular?language=en-UK&page=1")
    fun getPopularFilms(@Query("api_key") apiKey: String): Single<List<MovieResult>>
}