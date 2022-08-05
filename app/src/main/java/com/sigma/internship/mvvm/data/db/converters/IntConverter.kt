package com.sigma.internship.mvvm.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sigma.internship.mvvm.data.db.convertermodels.Genres
//https://peaku.co/questions/20052-como-resolver-%26quot;las-entidades-y-los-pojo-deben-tener-un-constructor-publico-utilizable%26quot;

class IntConverter {
    @TypeConverter
    fun fromGenres(value: Genres): String {
        return Gson().toJson(value)
    }
    @TypeConverter
    fun toGenres(value: String): Genres {
        return Gson().fromJson(value,Genres::class.java)
    }
}


