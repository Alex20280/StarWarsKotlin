package com.sigma.internship.mvvm.ui.models.cast

import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponse

data class CastLocalModel(
    val id : Int,
    val cast :ArrayList<CastResponse>
)

