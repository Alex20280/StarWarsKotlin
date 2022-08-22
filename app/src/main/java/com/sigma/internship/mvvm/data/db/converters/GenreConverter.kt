package com.sigma.internship.mvvm.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sigma.internship.mvvm.data.db.convertermodels.Genres

class GenreConverter {

    @TypeConverter
    fun fromGenres(value: Genres): String {
        return Gson().toJson(value)
    }
    @TypeConverter
    fun toGenres(value: String): Genres {
        return Gson().fromJson(value, Genres::class.java)
    }

}