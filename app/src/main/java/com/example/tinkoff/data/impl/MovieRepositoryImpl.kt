package com.example.tinkoff.data.impl

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.tinkoff.data.database.MovieDatabase
import com.example.tinkoff.data.database.mapper.MovieStorageMapper
import com.example.tinkoff.data.retrofit.ApiFactory
import com.example.tinkoff.data.retrofit.mapper.MovieTDOMapper
import com.example.tinkoff.domain.model.Movie
import com.example.tinkoff.domain.model.MovieDetail
import com.example.tinkoff.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(application: Application) : MovieRepository {

    private val movieDao = MovieDatabase.getInstance(context = application).movieDao()
    private val movieStorageMapper = MovieStorageMapper()
    private val movieTDOMapper = MovieTDOMapper()

    override fun getFavoriteMovies(): LiveData<List<Movie>> {
        return movieDao.getFavoriteMoviesList().map {
            movieStorageMapper.mapListOfStorageToEntity(list = it)
        }
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetail {
        return withContext(Dispatchers.IO) {
            val movieDetail = ApiFactory.apiService.getMovieById(movieId = movieId)
            return@withContext movieTDOMapper.mapMovieDetailTDOtoEntity(movieDetailTDO = movieDetail)
        }
    }

    override suspend fun getTopMovies(page: Int): List<Movie> {
        return withContext(Dispatchers.IO) {
            val listOfTopMovies = ApiFactory.apiService.getTopMovie(page = page).listOfTopMovies
            listOfTopMovies?.map { movie -> movieTDOMapper.mapMovieTDOtoEntity(movie) }
                ?: throw RuntimeException("Context getFavoriteMovies == null")
        }
    }

    override suspend fun addMovie(movie: Movie) {
        withContext(Dispatchers.IO) {
            val detailMovie = movie.id?.let { getMovieDetail(movieId = it) }
            detailMovie?.let { movieStorageMapper.mapMovieDetailEntityToStorage(movieDetail = it) }
                ?.let { movieDao.addMovieInfo(movie = it) }
            movie.isFavorite = true
            movieDao.addMovie(movieStorageMapper.mapMovieEntityToStorage(movie = movie))
        }

    }

    override suspend fun deleteFavoriteMovie(movieId: Int) {
        withContext(Dispatchers.IO) {
            movieDao.deleteFavoriteMovie(movieId = movieId)
        }
    }

    override suspend fun getFavoriteMovie(movieId: Int): MovieDetail {
        return withContext(Dispatchers.IO) {
            val movieStorage = movieDao.getFavoriteMovie(movieId = movieId)
            if (movieStorage != null) {
                return@withContext movieStorageMapper.mapMovieDetailToEntity(movieStorage)
            } else {
                return@withContext movieTDOMapper.mapMovieDetailTDOtoEntity(
                    ApiFactory.apiService.getMovieById(
                        movieId = movieId
                    )
                )
            }
        }
    }

    override fun searchMovieByName(movieName: String): Movie {
        TODO("Not yet implemented")
    }

}