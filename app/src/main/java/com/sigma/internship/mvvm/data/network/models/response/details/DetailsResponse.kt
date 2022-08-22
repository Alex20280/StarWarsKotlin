package com.sigma.internship.mvvm.data.network.models.response.details

import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.db.entities.DetailsDbModel

data class DetailsResponse(
    val id: Int,
    val genres: List<GenreResponse>,
    val runtime: Int,
)

{
    fun convertToDataBaseModel(): DetailsDbModel {
        return DetailsDbModel(
            id,
            Genres(genres.get(0).id, genres.get(0).name),
            runtime
        )
    }
}