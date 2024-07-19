package com.example.tinkoff.domain.usecase

import com.example.tinkoff.domain.model.Movie
import com.example.tinkoff.domain.repository.MovieRepository

class GetTopMoviesUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(page : Int) : List<Movie> {
        return repository.getTopMovies(page = page)
    }

}