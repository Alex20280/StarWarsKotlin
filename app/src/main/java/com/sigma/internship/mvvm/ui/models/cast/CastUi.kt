package com.sigma.internship.mvvm.ui.models.cast

import com.sigma.internship.mvvm.data.db.entities.CastDbModel

data class CastUi (
    var name: String?,
    var profile_path: String?,
    var character: String?
)


{
    companion object {
        fun fromDatabaseEntities(cast: CastDbModel): CastUi {
            return CastUi(
                name = cast.cast.name,
                profile_path = cast.cast?.profile_path,
                character = cast.cast.character
            )
        }
    }

}