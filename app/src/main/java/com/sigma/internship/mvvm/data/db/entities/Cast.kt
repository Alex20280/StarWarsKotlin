package com.sigma.internship.mvvm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sigma.internship.mvvm.data.network.models.response.cast.Cast

@Entity(tableName = "cast")
data class Cast(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movie_id")
    val id : Int,
    val cast :ArrayList<Cast>
)