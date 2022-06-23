package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "response")
data class MovieResponseModel(
    @PrimaryKey(autoGenerate = false)
    val page: Int,
    val results: ArrayList<MovieResponse>
)