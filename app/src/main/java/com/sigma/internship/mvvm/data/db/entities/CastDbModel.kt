package com.sigma.internship.mvvm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sigma.internship.mvvm.data.db.convertermodels.Cast
import com.sigma.internship.mvvm.data.db.converters.CastConverter

@Entity(tableName = "cast_model")
data class CastDbModel(
    @PrimaryKey(autoGenerate = false)
    var id : Int,
    @ColumnInfo (name = "cast")
    var cast : Cast
)
{
    constructor() : this(0, Cast(CastDb()))
}

