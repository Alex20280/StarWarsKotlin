package com.sigma.internship.mvvm.data.network.models.response.popular

import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.ResultLocalModel

data class ResultResponseModel(
    val page: Int,
    val results :ArrayList<MovieResponseModel>
)

{
    fun convertToLocalModel(): ResultLocalModel {
        return ResultLocalModel(
            page,
            results
        )
    }
}