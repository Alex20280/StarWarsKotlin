package com.sigma.internship.mvvm.data.network.models.response.movie

import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

data class MovieResponseModel(
    val poster_path: String,
    val overview: String,
    val title: String,
    val genre_ids: ArrayList<Int>)

{
    fun convertToLocalModel(): MovieLocalModel {
        return MovieLocalModel(
            poster_path,
            overview,
            title,
            genre_ids
        )
    }
}