package com.example.tinkoff.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class MovieDetailTDO(
    @SerializedName("kinopoiskId") val id : Int? = null,
    @SerializedName("nameRu") val name : String? = null,
    @SerializedName("posterUrl") val url : String? = null,
    @SerializedName("genres") val listOfGenre : List<GenreTDO>? = null,
    @SerializedName("countries") val listOfCountries : List<CountryTDO>? = null,
    @SerializedName("description") val description : String? = null
)