package com.sigma.internship.mvvm.data.network.models.response.cast

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.sigma.internship.mvvm.ui.models.cast.CastLocal

@Entity(tableName = "cast_and_crew")
data class CastAndCrew(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "actor_name")
    val name: String,
    @ColumnInfo(name = "actor_image")
    val profile_path: String,
    @ColumnInfo(name = "character_name")
    val character: String
) {

    fun convertToLocalModel(): CastLocal {
        return CastLocal(
            name,
            profile_path,
            character
        )
    }
}