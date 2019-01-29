package com.example.tinnovakovic.popularmovies_kotlin.ui.detail

import com.example.tinnovakovic.popularmovies_kotlin.Const.API_KEY
import com.example.tinnovakovic.popularmovies_kotlin.api.RestService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class DetailPresenter(private val view: DetailContract.DetailView) : DetailContract.DetailPresenter {

    override fun getMovieData(movieId: Int) {

        RestService()
                .getTrailers(movieId, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            view.showTrailers(it)

                        },
                        onError = {
                            it.printStackTrace()
                        }
                )

        RestService()
                .getCast(movieId, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            view.showCast(it)

                        },
                        onError = {
                            it.printStackTrace()
                        }
                )

        RestService()
                .getReviews(movieId, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            view.showReviews(it)

                        },
                        onError = {
                            it.printStackTrace()
                        }
                )

    }
    // Looking at these articles:
//    https://stackoverflow.com/questions/30219877/rxjava-android-how-to-use-the-zip-operator/30221196
//    Arsenal Project
//    private fun zipTrailerCastReview(): Single<List<Detail>> = Single.zip(
//            restService.getTrailers(movieId, Const.API_KEY)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread()),
//
//            restService.getCast(movieId, Const.API_KEY)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread()),
//
//            restService.getReviews(movieId, Const.API_KEY)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread()),
//
//            new Func2<Trailer, Cast, Review, Detail>(){
//
////            BiFunction<List<Detail>, List<Trailer>, List<Cast>,List<Review{ trailers, casts, reviews ->
//
//                injuries.forEach { injury ->
//                    players.forEach { player ->
//                        if (player.paid == injury.playerPaid) {
//                            player.injury = injury
//                        }
//                    }
//                }
//                return@BiFunction players
//            })

//    override fun getMovieData(movieId: Int) {
//
//
////        Single<Trailer>() trailerSingle = RestService()
////                .getTrailers(movieId, API_KEY)
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////
////        RestService()
////                .getCast(movieId, API_KEY)
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////
////        RestService()
////                .getReviews(movieId, API_KEY)
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////
////        Single<Trailer> trailer = Single
//
//        Observable.zip(
//                getTrailers(movieId, Const.API_KEY),
//                getCast(movieId, Const.API_KEY),
//                getReviews(movieId, Const.API_KEY), new Func2 < Trailer, Cast, Review, Detail > (){
//
//        })
//    }


}
