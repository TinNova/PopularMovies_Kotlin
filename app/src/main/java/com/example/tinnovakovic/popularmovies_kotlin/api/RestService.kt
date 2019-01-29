package com.example.tinnovakovic.popularmovies_kotlin.api

import com.example.tinnovakovic.popularmovies_kotlin.Const.BASE_URL
import com.example.tinnovakovic.popularmovies_kotlin.data.*
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Inject


class RestService {

    private  var INSTANCE: ApiMethods

    init {


        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(provideOkHttp())
                .build()

        INSTANCE = retrofit.create<ApiMethods>(ApiMethods::class.java)



    }


//    @Inject lateinit var apiMethods: ApiMethods

    private fun provideOkHttp(): OkHttpClient {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    fun getFilms(popularFilms: Boolean, apiKey: String) =
            if (popularFilms) getPopularFilms(apiKey) else getTopRatedFilms(apiKey)

   private fun getTopRatedFilms(apiKey: String): Single<Movie> {
        return INSTANCE.getTopRatedFilms(apiKey)
    }

    private fun getPopularFilms(apiKey: String): Single<Movie> {
        return INSTANCE.getPopularFilms(apiKey)
    }

    fun getTrailers(movieId: Int, apiKey: String): Single<Trailer> {
        return INSTANCE.getTrailers(movieId, apiKey)
    }

    fun getCast(movieId: Int, apiKey: String): Single<Cast> {
        return INSTANCE.getCast(movieId, apiKey)
    }

    fun getReviews(movieId: Int, apiKey: String): Single<Review> {
        return INSTANCE.getReviews(movieId, apiKey)
    }


}
