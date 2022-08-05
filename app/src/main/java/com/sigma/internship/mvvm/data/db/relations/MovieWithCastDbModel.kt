package com.sigma.internship.mvvm.data.db.relations

import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

@Entity(tableName = "movie_cast")
class MovieWithCastDbModel(
    @Embedded
    var movie: MovieDbModel,
    @Relation(
        entity = CastDbModel::class,
        parentColumn = "id",
        entityColumn = "id"
    )
    var cast : CastDbModel
)

/*
@Entity(tableName = "movie_cast")
data class MovieWithCastDbModel(
    @Embedded
    @PrimaryKey(autoGenerate = false)
    val movieResponse: MovieDbModel,
    @Relation(
        entity = CastDbModel::class,
        parentColumn = "id",
        entityColumn = "id"
    )
    val castList: List<CastDbModel>

)*/
