package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieDbModel(
    var page: Int,
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var poster_path: String,
    var overview: String,
    var original_title: String)

/*
{
    fun convertToLocalModel(): MovieLocalModel {
        return MovieLocalModel(
            page,
            id,
            poster_path,
            overview,
            original_title
        )
    }
}
*/


