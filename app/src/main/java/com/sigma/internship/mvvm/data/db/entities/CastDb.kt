package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cast")
data class CastDb(
    @PrimaryKey(autoGenerate = false)
    var name: String,
    var profile_path: String,
    var character: String)

{
    constructor() : this("", "", "")
}
