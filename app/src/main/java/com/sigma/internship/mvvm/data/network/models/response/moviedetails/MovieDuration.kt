package com.sigma.internship.mvvm.data.network.models.response.moviedetails

import com.sigma.internship.mvvm.ui.models.moviewdetails.MovieDurationLocalModel

data class MovieDuration(
    val id: Int,
    val runtime: Int
)

{
    fun convertToLocalModel(): MovieDurationLocalModel {
        return MovieDurationLocalModel(
            id,
            runtime
        )
    }
}