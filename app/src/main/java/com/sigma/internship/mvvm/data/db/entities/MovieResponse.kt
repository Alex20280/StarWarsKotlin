package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieResponse(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val poster_path: String,
    val overview: String,
    val title: String,
    val genre_ids: ArrayList<Int>,
    val runtime: Int)


