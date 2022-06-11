package com.sigma.internship.mvvm.data.network.models.response.cast

import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel

data class CastModel(
    val id: Int,
    val cast: ArrayList<Cast>
) {
    fun convertToLocalModel(): CastLocalModel {
        return CastLocalModel(
            id,
            cast
        )
    }
}