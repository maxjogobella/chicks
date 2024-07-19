package com.example.tinkoff.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetail(
    val id : Int? = null,
    val name : String? = null,
    val description : String? = null,
    val url : String? = null,
    val listOfCountries : List<Country>? = null,
    val listOfGenres : List<Genre>? = null
) : Parcelable