package com.sigma.internship.mvvm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sigma.internship.mvvm.data.db.convertermodels.Cast
import com.sigma.internship.mvvm.data.db.converters.CastConverter
import com.sigma.internship.mvvm.data.db.converters.IntConverter
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.cast.CastUi

@Entity(tableName = "cast")
@TypeConverters(CastConverter::class)
data class CastDbModel(
    @PrimaryKey(autoGenerate = false)
    var id : Int,
    @ColumnInfo(name = "cast")
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