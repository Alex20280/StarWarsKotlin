package com.sigma.internship.mvvm.data.network.models.response.movie

import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

data class ResultResponseModel(
    val results: ArrayList<MovieResponse>
) {

    fun convertToDataBaseModel(): MovieDbModel {
        return MovieDbModel(
            results.get(1).id,
            results.get(1).poster_path,
            results.get(1).overview,
            results.get(1).title
        )
    }
}