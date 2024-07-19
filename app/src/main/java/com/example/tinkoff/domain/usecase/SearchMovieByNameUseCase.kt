package com.example.tinkoff.domain.usecase

import com.example.tinkoff.domain.repository.MovieRepository

class SearchMovieByNameUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(movieName : String) {
        repository.searchMovieByName(movieName = movieName)
    }

}