package com.example.tinkoff.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class MovieTDO(
    @SerializedName("kinopoiskId") val id : Int? = null,
    @SerializedName("nameRu") val name: String? = null,
    @SerializedName("posterUrl") val url : String? = null,
    @SerializedName("year") val year : Int? = null,
    @SerializedName("genres") val listOfGenres : List<GenreTDO>? = null
)