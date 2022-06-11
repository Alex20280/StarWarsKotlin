package com.sigma.internship.mvvm.ui.models.cast

import com.sigma.internship.mvvm.data.network.models.response.cast.Cast
import com.sigma.internship.mvvm.data.network.models.response.cast.CastModel

data class CastLocalModel(
    val id : Int,
    val cast :ArrayList<Cast>
)

