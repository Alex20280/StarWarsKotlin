package com.sigma.internship.mvvm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.db.converters.IntConverter
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

@Entity(tableName = "movie")
@TypeConverters(IntConverter::class)
data class MovieDbModel(
    var page: Int,
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var poster_path: String,
    var overview: String,
    var title: String,
    var genre_ids: Genres,
    var runtime: Int)

{
    fun convertToLocalModel(): MovieLocalModel {
        return MovieLocalModel(
            page,
            id,
            poster_path,
            overview,
            title,
            genre_ids,
            runtime
        )
    }
}