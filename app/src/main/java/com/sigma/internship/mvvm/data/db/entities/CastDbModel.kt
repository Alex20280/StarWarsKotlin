package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sigma.internship.mvvm.data.db.convertermodels.Cast
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.cast.CastUi

@Entity(tableName = "cast")
data class CastDbModel(
    @PrimaryKey(autoGenerate = false)
    var id : Int,
    val cast: Cast
)

{

    fun convertToLocalModel(): CastLocal {
        return CastLocal(
            id,
            CastUi("", "", "")
        )
    }
}