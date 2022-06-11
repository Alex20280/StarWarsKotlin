package com.sigma.internship.mvvm.ui.models.popular

import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

data class PopularLocalModel(
    val page: Int,
    val results :ArrayList<MovieLocalModel>

)
