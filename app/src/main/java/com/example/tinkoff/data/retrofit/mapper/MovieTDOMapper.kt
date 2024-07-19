package com.example.tinkoff.data.retrofit.mapper

import com.example.tinkoff.data.retrofit.model.CountryTDO
import com.example.tinkoff.data.retrofit.model.GenreTDO
import com.example.tinkoff.data.retrofit.model.MovieDetailTDO
import com.example.tinkoff.data.retrofit.model.MovieTDO
import com.example.tinkoff.domain.model.Country
import com.example.tinkoff.domain.model.Genre
import com.example.tinkoff.domain.model.Movie
import com.example.tinkoff.domain.model.MovieDetail

class MovieTDOMapper {

    fun mapMovieTDOtoEntity(movieTDO: MovieTDO): Movie {
        return Movie(
            id = movieTDO.id,
            name = movieTDO.name,
            url = movieTDO.url,
            year = movieTDO.year,
            listOfGenre = movieTDO.listOfGenres?.let { mapListOfGenresToEntity(list = it) }

        )
    }

     fun mapMovieDetailTDOtoEntity(movieDetailTDO: MovieDetailTDO): MovieDetail {
        return MovieDetail(
            id = movieDetailTDO.id,
            name = movieDetailTDO.name,
            url = movieDetailTDO.url,
            description = movieDetailTDO.description,
            listOfGenres = movieDetailTDO.listOfGenre?.let { mapListOfGenresToEntity(list = it) },
            listOfCountries = movieDetailTDO.listOfCountries?.let { mapListOfCountriesToEntity(list = it) }
        )
    }

    private fun mapListOfCountriesToEntity(list: List<CountryTDO>): List<Country> {
        return list.map { mapCountryToEntity(country = it) }
    }

    private fun mapCountryToEntity(country : CountryTDO): Country {
        return Country(name = country.name)
    }

    private fun mapListOfGenresToEntity(list: List<GenreTDO>): List<Genre> {
        return list.map { mapGenreToEntity(genre = it) }
    }

    private fun mapGenreToEntity(genre: GenreTDO): Genre {
        return Genre(name = genre.name)
    }

}