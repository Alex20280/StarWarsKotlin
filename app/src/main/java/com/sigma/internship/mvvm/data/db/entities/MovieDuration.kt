package com.sigma.internship.mvvm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sigma.internship.mvvm.ui.models.moviewdetails.MovieDurationLocalModel

@Entity(tableName = "movie_duration")
data class MovieDuration(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movie_id")
    val id: Int,
    @ColumnInfo(name = "duration")
    val runtime: Int
)