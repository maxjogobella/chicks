package com.example.tinkoff.domain.usecase

import com.example.tinkoff.domain.model.MovieDetail
import com.example.tinkoff.domain.repository.MovieRepository

class GetFavoriteMovieUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(movieId : Int) : MovieDetail? {
        return movieRepository.getFavoriteMovie(movieId = movieId)
    }

}