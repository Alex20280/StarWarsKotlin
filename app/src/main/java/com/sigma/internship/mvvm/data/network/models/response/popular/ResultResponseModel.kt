package com.sigma.internship.mvvm.data.network.models.response.popular

import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponse
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel

data class ResultResponseModel(
    val page: Int,
    val results :ArrayList<MovieResponseModel>
)

