package com.example.tinkoff.domain.repository

import androidx.lifecycle.LiveData
import com.example.tinkoff.data.database.model.MovieDetailStorage
import com.example.tinkoff.data.database.model.MovieStorage
import com.example.tinkoff.domain.model.Movie
import com.example.tinkoff.domain.model.MovieDetail

interface MovieRepository {

    fun getFavoriteMovies() : LiveData<List<Movie>>
    suspend fun getMovieDetail(movieId : Int) : MovieDetail
    suspend fun getTopMovies(page : Int) : List<Movie>
    suspend fun addMovie(movie: Movie)
    suspend fun deleteFavoriteMovie(movieId: Int)
    suspend fun getFavoriteMovie(movieId: Int): MovieDetail
    fun searchMovieByName(movieName : String) : Movie

}