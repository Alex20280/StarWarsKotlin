package com.sigma.internship.mvvm.data.network.models.response.details

import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

data class DetailsResponse(
    val id: Int,
    val overview: String,
    val poster_path: String,
    val title: String,
    val genres: List<GenreResponse>,
    val runtime: Int,
)

{
    fun convertToDataBaseModel(): MovieDbModel {
        return MovieDbModel(
            page = 1,
            id,
            overview,
            poster_path,
            title,
            Genres(), //TODO
            runtime
        )
    }
}