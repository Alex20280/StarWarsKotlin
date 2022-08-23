package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieDbModel(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var poster_path: String,
    var overview: String,
    var title: String)

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


