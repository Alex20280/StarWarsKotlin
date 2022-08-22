package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.db.converters.CastConverter
import com.sigma.internship.mvvm.data.db.converters.GenreConverter

@Entity(tableName = "details")
@TypeConverters(GenreConverter::class)
data class DetailsDbModel (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val genres: Genres,
    val runtime: Int,
)

/*
{
    fun convertToLocalModel(): DetailsUI {
        return DetailsUI(
            id,
            arrayListOf<GenreUi>(),
            runtime
        )
    }
}*/
