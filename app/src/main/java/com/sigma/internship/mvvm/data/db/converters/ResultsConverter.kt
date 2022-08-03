package com.sigma.internship.mvvm.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sigma.internship.mvvm.data.db.convertermodels.Cast
import com.sigma.internship.mvvm.data.db.convertermodels.Results
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ResultsConverter {

    @TypeConverter
    fun fromResults(value: Results): String {
        return Gson().toJson(value)
    }
    @TypeConverter
    fun toResults(value: String): Results {
        return Gson().fromJson(value, Results::class.java)
    }
}
