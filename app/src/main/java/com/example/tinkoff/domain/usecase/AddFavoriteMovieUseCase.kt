package com.example.tinkoff.domain.usecase

import com.example.tinkoff.domain.model.Movie
import com.example.tinkoff.domain.repository.MovieRepository

class AddFavoriteMovieUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(movie : Movie) {
        movieRepository.addMovie(movie = movie)
    }
}