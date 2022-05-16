package com.sigma.internship.mvvm.data.network.models.response.cast

import com.sigma.internship.mvvm.ui.models.cast.CastLocal

data class CastAndCrew(
    val name: String,
    val profile_path: String,
    val character: String
) {
    fun convertToLocalModel(): CastLocal {
        return CastLocal(
            name,
            profile_path,
            character
        )
    }
}