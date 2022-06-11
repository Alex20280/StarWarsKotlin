package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sigma.internship.mvvm.data.network.models.response.cast.Cast

@Entity(tableName = "cast_model")
data class CastModel(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val cast :ArrayList<Cast>
)