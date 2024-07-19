package com.example.tinkoff.data.database.mapper

import com.example.tinkoff.data.database.model.CountryStorage
import com.example.tinkoff.data.database.model.GenreStorage
import com.example.tinkoff.data.database.model.MovieDetailStorage
import com.example.tinkoff.data.database.model.MovieStorage
import com.example.tinkoff.domain.model.Country
import com.example.tinkoff.domain.model.Genre
import com.example.tinkoff.domain.model.Movie
import com.example.tinkoff.domain.model.MovieDetail

class MovieStorageMapper {

    private fun mapMovieToEntity(movieStorage: MovieStorage): Movie {
        return Movie(
            id = movieStorage.id,
            name = movieStorage.name,
            url = movieStorage.url,
            year = movieStorage.year,
            listOfGenre = movieStorage.listOfGenre?.let { mapListOfGenreToEntity(list = it) },
            isFavorite = movieStorage.isFavorite
        )
    }

    fun mapMovieDetailToEntity(movieDetailStorage: MovieDetailStorage): MovieDetail {
        return MovieDetail(
            id = movieDetailStorage.id,
            name = movieDetailStorage.name,
            description = movieDetailStorage.description,
            url = movieDetailStorage.url,
            listOfCountries = movieDetailStorage.listOfCountry?.let {
                mapListOfCountriesToEntity(
                    list = it
                )
            },
            listOfGenres = movieDetailStorage.listOfGenre?.let { mapListOfGenreToEntity(list = it) }

        )
    }

    fun mapMovieEntityToStorage(movie: Movie): MovieStorage {
        return MovieStorage(
            id = movie.id,
            name = movie.name,
            url = movie.url,
            year = movie.year,
            isFavorite = movie.isFavorite,
            listOfGenre = movie.listOfGenre?.let { mapListOfGenresToStorage(list = it) }
        )
    }

    fun mapMovieDetailEntityToStorage(movieDetail: MovieDetail): MovieDetailStorage {
        return MovieDetailStorage(
            id = movieDetail.id,
            name = movieDetail.name,
            url = movieDetail.url,
            description = movieDetail.description,
            listOfGenre = movieDetail.listOfGenres?.let { mapListOfGenresToStorage(list = it) },
            listOfCountry = movieDetail.listOfCountries?.let { mapListOfCountriesToStorage(list = it) }

        )
    }

    fun mapListOfStorageToEntity(list : List<MovieStorage>) : List<Movie> {
        return list.map { mapMovieToEntity(movieStorage = it) }
    }

    private fun mapListOfCountriesToStorage(list: List<Country>): List<CountryStorage> {
        return list.map { mapCountryToStorage(country = it) }
    }

    private fun mapCountryToStorage(country: Country): CountryStorage {
        return CountryStorage(name = country.name)
    }

    private fun mapListOfGenresToStorage(list: List<Genre>): List<GenreStorage> {
        return list.map { mapGenreToStorage(genre = it) }
    }

    private fun mapGenreToStorage(genre: Genre): GenreStorage {
        return GenreStorage(name = genre.name)
    }

    private fun mapListOfCountriesToEntity(list: List<CountryStorage>): List<Country> {
        return list.map { mapCountriesToEntity(country = it) }
    }

    private fun mapListOfGenreToEntity(list: List<GenreStorage>): List<Genre> {
        return list.map { mapGenresToEntity(genre = it) }
    }

    private fun mapCountriesToEntity(country: CountryStorage): Country {
        return Country(name = country.name)
    }

    private fun mapGenresToEntity(genre: GenreStorage): Genre {
        return Genre(name = genre.name)
    }

}