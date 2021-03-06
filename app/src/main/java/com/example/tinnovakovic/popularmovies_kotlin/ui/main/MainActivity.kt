package com.example.tinnovakovic.popularmovies_kotlin.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.tinnovakovic.popularmovies_kotlin.Const.MOVIE_ID
import com.example.tinnovakovic.popularmovies_kotlin.Const.MOVIE_POSTER
import com.example.tinnovakovic.popularmovies_kotlin.Const.MOVIE_RATING
import com.example.tinnovakovic.popularmovies_kotlin.Const.MOVIE_RELEASE_DATE
import com.example.tinnovakovic.popularmovies_kotlin.Const.MOVIE_SYNOPSIS
import com.example.tinnovakovic.popularmovies_kotlin.Const.MOVIE_TITLE
import com.example.tinnovakovic.popularmovies_kotlin.R
import com.example.tinnovakovic.popularmovies_kotlin.Utils
import com.example.tinnovakovic.popularmovies_kotlin.data.Movie
import com.example.tinnovakovic.popularmovies_kotlin.data.MovieResult
import com.example.tinnovakovic.popularmovies_kotlin.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {

    private lateinit var presenter: MainPresenter
    private var popularFilms = true

    private val movieAdapter: MovieAdapter by lazy { MovieAdapter { launchDetailActivity(it) } }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        setUpViews()
    }

    private fun setUpViews() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        isOnline()
    }

    override fun showData(movie: Movie) {
        Log.d("Show 0th Movies Title: ", movie.results[0].title)
        recyclerView.adapter = movieAdapter
        movieAdapter.setData(movie.results)
    }

    private fun launchDetailActivity(movieResult: MovieResult) {
        Log.d("CLICKED", movieResult.title)
        val intent = Intent (this, DetailActivity::class.java)
        intent.putExtra(MOVIE_POSTER, movieResult.posterPath)
        intent.putExtra(MOVIE_TITLE, movieResult.title)
        intent.putExtra(MOVIE_SYNOPSIS, movieResult.overview)
        intent.putExtra(MOVIE_RATING, movieResult.voteAverage)
        intent.putExtra(MOVIE_RELEASE_DATE, movieResult.releaseDate)
        intent.putExtra(MOVIE_ID, movieResult.id)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.filter_by_popular ->
                if (!popularFilms) {
                    popularFilms = true
                    presenter.getMovies(popularFilms)
                }

            R.id.filter_by_rating ->
                if (popularFilms) {
                    popularFilms = false
                    presenter.getMovies(popularFilms)
                }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun isOnline() {

        if (!Utils.isOnline(this)) {

            noWifiIcon.visibility = View.VISIBLE
            noWifiText.visibility = View.VISIBLE
            retryWifiBtn.visibility = View.VISIBLE

            retryWifiBtn.setOnClickListener { isOnline() }

            Toast.makeText(baseContext, "No Internet Connection", Toast.LENGTH_LONG).show()
        } else {

            presenter.getMovies(popularFilms)
            noWifiIcon.visibility = View.GONE
            noWifiText.visibility = View.GONE
            retryWifiBtn.visibility = View.GONE
        }

    }
}
