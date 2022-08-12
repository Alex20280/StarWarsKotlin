package com.sigma.internship.mvvm.data.network.models.response.movie

data class ResultResponseModel(
    val page: Int,
    val results :ArrayList<MovieResponse>
)

