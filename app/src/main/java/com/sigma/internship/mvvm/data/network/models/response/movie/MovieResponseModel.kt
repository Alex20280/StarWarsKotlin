package com.sigma.internship.mvvm.data.network.models.response.movie

import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

data class MovieResponseModel(
    val id: Int,
    val poster_path: String,
    val overview: String,
    val original_title: String,
    val genres: ArrayList<Int>,
    val runtime: Int)

{
    fun convertToLocalModel(): MovieLocalModel {
        return MovieLocalModel(
            id,
            poster_path,
            overview,
            original_title,
            genres,
            runtime
        )
    }
}