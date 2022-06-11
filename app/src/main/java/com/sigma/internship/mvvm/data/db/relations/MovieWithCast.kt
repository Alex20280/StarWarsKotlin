package com.sigma.internship.mvvm.data.db.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.sigma.internship.mvvm.data.db.entities.CastModel
import com.sigma.internship.mvvm.data.db.entities.MovieResponse

@Entity(tableName = "movie_cast")
data class MovieWithCast(
    @Embedded
    val movieResponse: MovieResponse,
    @Relation(
        entity = CastModel::class,
        parentColumn = "id",
        entityColumn = "id"
    )
    val castList: List<CastModel>

)