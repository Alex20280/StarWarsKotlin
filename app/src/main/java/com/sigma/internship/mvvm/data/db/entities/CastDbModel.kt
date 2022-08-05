package com.sigma.internship.mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sigma.internship.mvvm.ui.models.cast.CastLocal

@Entity(tableName = "cast")
data class CastDbModel(
    @PrimaryKey(autoGenerate = false)
    var id : Int,
    var name: String,
    var profile_path: String,
    var character: String)

{

    fun convertToLocalModel(): CastLocal {
        return CastLocal(
            id,
            name,
            profile_path,
            character
        )
    }
}