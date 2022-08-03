package com.sigma.internship.mvvm.data.network.models.response.cast

import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel

data class CastResponseModel(
    val id: Int,
    val cast: ArrayList<CastResponse>
) {
    fun convertToLocalModel(): CastLocalModel {
        return CastLocalModel(
            id,
            cast
        )
    }
}