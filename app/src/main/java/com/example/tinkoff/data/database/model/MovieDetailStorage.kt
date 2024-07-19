package com.example.tinkoff.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("movie_detail_table")
data class MovieDetailStorage(
    @PrimaryKey val id : Int? = null,
    val name : String? = null,
    val description : String? = null,
    val url : String? = null,
    val listOfCountry : List<CountryStorage>? = null,
    val listOfGenre : List<GenreStorage>? = null
)