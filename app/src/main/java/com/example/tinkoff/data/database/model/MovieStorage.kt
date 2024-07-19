package com.example.tinkoff.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("movie_table")
data class MovieStorage(
    @PrimaryKey val id : Int? = null,
    val name : String? = null,
    val url : String? = null,
    val year : Int? = null,
    val listOfGenre : List<GenreStorage>? = null,
    var isFavorite : Boolean? = null
)