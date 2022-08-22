package com.sigma.internship.mvvm.ui.models.movie

import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.db.entities.DetailsDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

data class MovieAndDetailsUi (

    val page: Int,
    val id: Int,
    val poster_path: String,
    val overview: String,
    val original_title: String,
    val genres: List<GenreUi>,
    val runtime: Int,

    )
{
    companion object {
        fun fromDatabaseEntities(movie: MovieDbModel, details: DetailsDbModel): MovieAndDetailsUi {
            return MovieAndDetailsUi(
                page = movie.page,
                id = movie.id,
                poster_path = movie.poster_path,
                overview = movie.overview,
                original_title = movie.original_title,
                genres = mutableListOf(GenreUi(details.genres.id, details.genres.name)),
                runtime = details.runtime
            )
        }
    }

}