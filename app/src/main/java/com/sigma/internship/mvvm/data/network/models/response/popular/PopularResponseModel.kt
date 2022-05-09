package com.sigma.internship.mvvm.data.network.models.response.popular

import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

data class PopularResponseModel(
    val results :ArrayList<MovieResponseModel>
)