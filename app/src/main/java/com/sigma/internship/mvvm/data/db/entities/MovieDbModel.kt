package com.sigma.internship.mvvm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.db.convertermodels.Results
import com.sigma.internship.mvvm.data.db.converters.IntConverter

@Entity(tableName = "movie")
data class MovieDbModel(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var poster_path: String,
    var overview: String,
    var title: String,
    @ColumnInfo(name = "genre_ids")
    var genre_ids: Genres,
    var runtime: Int)


{
    constructor() : this(0, "", "", "", Genres(0),0)
}

