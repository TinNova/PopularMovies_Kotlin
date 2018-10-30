package com.example.tinnovakovic.popularmovies_kotlin.data
import com.google.gson.annotations.SerializedName



data class Review(
    @SerializedName("id") val id: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<ReviewResult>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)

data class ReviewResult(
    @SerializedName("author") val author: String,
    @SerializedName("content") val content: String,
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String
)