package com.example.tinkoff.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinkoff.data.database.model.MovieDetailStorage
import com.example.tinkoff.data.database.model.MovieStorage

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getFavoriteMoviesList(): LiveData<List<MovieStorage>>

    @Query("SELECT * FROM movie_detail_table WHERE id=:movieId LIMIT 1")
    suspend fun getFavoriteMovie(movieId: Int): MovieDetailStorage

    @Query("DELETE FROM movie_detail_table WHERE id=:movieId")
    suspend fun deleteFavoriteMovie(movieId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movie: MovieStorage)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieInfo(movie: MovieDetailStorage)

    @Query("DELETE FROM movie_table WHERE id=:movieId")
    suspend fun removeMovie(movieId: Int)
}