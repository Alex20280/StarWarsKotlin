package com.sigma.internship.mvvm.data.network.models.response.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

data class MovieResponseModel(
    val id: Int,
    val poster_path: String,
    val overview: String,
    val title: String,
    val genre_ids: ArrayList<Int>)

{
    fun convertToLocalModel(): MovieLocalModel {
        return MovieLocalModel(
            id,
            poster_path,
            overview,
            title,
            genre_ids
        )
    }
}