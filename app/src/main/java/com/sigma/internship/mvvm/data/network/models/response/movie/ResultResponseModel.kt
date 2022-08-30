package com.sigma.internship.mvvm.data.network.models.response.movie

import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

data class ResultResponseModel(
    val results: ArrayList<MovieResponse>
)



/*{
    fun convertToDataBaseModel(): MovieDbModel {


        return MovieDbModel(
            results.get(0).id,
            results.get(0).poster_path,
            results.get(0).overview,
            results.get(0).title
        )
    }
}*/
/*
{
    fun convertToDataBaseModel(): MovieDbModel {
        return MovieDbModel(
            results.forEach { it.id },
            results.map { it.poster_path },
            results.map { it.overview }.also { it.toString() },
            results.map { it.title }.also { it.toString() }
        )
    }
}*/
