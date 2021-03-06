package com.example.tinnovakovic.popularmovies_kotlin.data
import com.google.gson.annotations.SerializedName



data class Cast(
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val cast: List<CastResult>,
    @SerializedName("crew") val crew: List<CrewResult>
)

data class CastResult(
    @SerializedName("cast_id") val castId: Int,
    @SerializedName("character") val character: String,
    @SerializedName("credit_id") val creditId: String,
    @SerializedName("gender") val gender: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("profile_path") val profilePath: Any
)

data class CrewResult(
    @SerializedName("credit_id") val creditId: String,
    @SerializedName("department") val department: String,
    @SerializedName("gender") val gender: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("job") val job: String,
    @SerializedName("name") val name: String,
    @SerializedName("profile_path") val profilePath: Any
)