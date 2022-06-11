package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cast")
data class Cast(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val profile_path: String,
    val character: String
)