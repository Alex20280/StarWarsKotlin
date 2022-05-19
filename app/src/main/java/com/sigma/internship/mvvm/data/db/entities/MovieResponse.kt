package com.sigma.internship.mvvm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel


@Entity(tableName = "movie")
data class MovieResponse(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movie_id")
    val id: Int,
    @ColumnInfo(name = "movie_image")
    val poster_path: String,
    @ColumnInfo(name = "movie_overview")
    val overview: String,
    @ColumnInfo(name = "movie_title")
    val title: String,
    @ColumnInfo(name = "movie_genres")
    val genre_ids: ArrayList<Int>)
