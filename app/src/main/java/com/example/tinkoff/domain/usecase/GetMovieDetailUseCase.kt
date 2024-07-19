package com.example.tinkoff.domain.usecase

import com.example.tinkoff.domain.model.MovieDetail
import com.example.tinkoff.domain.repository.MovieRepository

class GetMovieDetailUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(movieId : Int) : MovieDetail {
        return repository.getMovieDetail(movieId = movieId)
    }

}