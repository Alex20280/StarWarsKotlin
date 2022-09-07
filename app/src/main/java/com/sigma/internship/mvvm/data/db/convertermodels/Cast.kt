package com.sigma.internship.mvvm.data.db.convertermodels

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class Cast(
    val name: String,
    val profile_path: String?,
    val character: String
)
