package com.sigma.internship.mvvm.ui.models.cast

import com.sigma.internship.mvvm.data.network.models.response.cast.CastAndCrew

data class CastAndCrewLocalModel(
    val id : Int,
    val cast :ArrayList<CastAndCrew>
)
