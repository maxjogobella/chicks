package com.example.tinkoff.domain.usecase

import com.example.tinkoff.domain.repository.MovieRepository

class RemoveFavoriteMovieUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(movieId : Int) {
        repository.deleteFavoriteMovie(movieId = movieId)
    }

}