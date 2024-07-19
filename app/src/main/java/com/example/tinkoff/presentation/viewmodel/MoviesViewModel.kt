package com.example.tinkoff.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tinkoff.data.impl.MovieRepositoryImpl
import com.example.tinkoff.domain.model.Movie
import com.example.tinkoff.domain.usecase.AddFavoriteMovieUseCase
import com.example.tinkoff.domain.usecase.GetFavoriteMoviesUseCase
import com.example.tinkoff.domain.usecase.GetTopMoviesUseCase
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.UnknownHostException
import kotlin.math.exp

class MoviesViewModel(application : Application) : AndroidViewModel(application) {

    init {
        loadTopMovies()
    }

    private var page = 1
    private val repository = MovieRepositoryImpl(application)
    private val getTopMoviesUseCase = GetTopMoviesUseCase(repository)
    private val addFavoriteMovieUseCase = AddFavoriteMovieUseCase(repository)
    private val getFavoriteMoviesUseCase = GetFavoriteMoviesUseCase(repository)

    private val _listOfMovies = MutableLiveData<List<Movie>>()
    private val _isLoading = MutableLiveData<Boolean>()
    private val _internetNotWorking = MutableLiveData<Boolean>()

    val listOfMovies : LiveData<List<Movie>>
        get() = _listOfMovies

    val isLoading : LiveData<Boolean>
        get() = _isLoading

    val internetNotWorking : LiveData<Boolean>
        get() = _internetNotWorking

    private fun loadTopMovies() {
        viewModelScope.launch {
            _isLoading.value = true
            _internetNotWorking.value = false

            runCatching {
                val movieResponse = getTopMoviesUseCase.invoke(page)
                updateMovieList(movieResponse)
                page++
            }.onFailure { exception -> handleFailure(exception) }

            _isLoading.value = false
        }
    }

    private fun updateMovieList(movie : List<Movie>) {
        val moviesFilled = _listOfMovies.value?.toMutableList()
        if (moviesFilled != null) {
            moviesFilled.addAll(movie)
            _listOfMovies.value = moviesFilled.toList()
        } else {
            _listOfMovies.value = movie
        }
    }

    private fun handleFailure(exception: Throwable) {
        if (exception is UnknownHostException) {
            _internetNotWorking.value = true
        }
    }

}