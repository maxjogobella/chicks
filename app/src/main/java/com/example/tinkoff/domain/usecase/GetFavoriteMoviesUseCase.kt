package com.example.tinkoff.domain.usecase

import androidx.lifecycle.LiveData
import com.example.tinkoff.domain.model.Movie
import com.example.tinkoff.domain.repository.MovieRepository

class GetFavoriteMoviesUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() : LiveData<List<Movie>> {
        return movieRepository.getFavoriteMovies()
    }
}