package com.sigma.internship.mvvm.ui.models.movie

import com.sigma.internship.mvvm.data.db.entities.DetailsDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

data class MovieAndDetailsUi (

    val id: Int,
    val poster_path: String?,
    val overview: String,
    val title: String,
    val genres: List<GenreUi>,
    val runtime: Int,

    )
{
    companion object {
        fun fromDatabaseEntities(movie: MovieDbModel, details: DetailsDbModel): MovieAndDetailsUi {
            return MovieAndDetailsUi(
                id = movie.id,
                poster_path = movie.poster_path,
                overview = movie.overview,
                title = movie.title,
                genres = mutableListOf(GenreUi(details.genres.id, details.genres.name)),
                runtime = details.runtime
            )
        }
    }

}