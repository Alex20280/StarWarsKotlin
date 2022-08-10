package com.sigma.internship.mvvm.data.network.models.response.cast

import com.sigma.internship.mvvm.data.db.convertermodels.Cast
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.cast.CastUi

data class CastResponseModel(
    val id: Int,
    val cast: ArrayList<CastResponse>
)

{

    fun convertToDataBaseModel(): CastDbModel {
        return CastDbModel(
            id,
            Cast(name = "", profile_path = "", character = "")
        )
    }
}