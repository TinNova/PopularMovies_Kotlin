package com.example.tinnovakovic.popularmovies_kotlin.ui.main

import com.example.tinnovakovic.popularmovies_kotlin.Const.API_KEY
import com.example.tinnovakovic.popularmovies_kotlin.api.RestService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainPresenter(private val view: MainContract.MainView) : MainContract.MainPresenter {

    override fun getMovies(popularFilms: Boolean) {

        RestService()
                .getFilms(popularFilms, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            view.showData(it)

                        },
                        onError = {
                            it.printStackTrace()
                        }
                )
    }
}

