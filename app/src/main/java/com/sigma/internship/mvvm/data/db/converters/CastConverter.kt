package com.sigma.internship.mvvm.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sigma.internship.mvvm.data.db.convertermodels.Cast
import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponse

class CastConverter {
    @TypeConverter
    fun fromCast(value: Cast): String {
        return Gson().toJson(value)
    }
    @TypeConverter
    fun toCast(value: String): Cast {
        return Gson().fromJson(value, Cast::class.java)
    }
}