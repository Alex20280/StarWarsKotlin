package com.sigma.internship.mvvm.ui.models.popular

import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

data class ResultLocalModel(
    val page: Int,
    val results: ArrayList<MovieResponseModel>

)
