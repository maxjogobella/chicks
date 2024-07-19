package com.example.tinkoff.data.retrofit.model

import com.example.tinkoff.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class TopMovieResponse (
    @SerializedName("items")
    val listOfTopMovies : List<MovieTDO>? = null
)