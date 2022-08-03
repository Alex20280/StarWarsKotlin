package com.sigma.internship.mvvm.data.db.relations

import androidx.room.*
import com.sigma.internship.mvvm.data.db.convertermodels.Cast
import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.db.convertermodels.Response
import com.sigma.internship.mvvm.data.db.converters.CastConverter
import com.sigma.internship.mvvm.data.db.entities.CastDb
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

@Entity(tableName = "movie_cast")
data class MovieWithCastDbModel(
    @Embedded
    @PrimaryKey(autoGenerate = false)
    @TypeConverters(Response::class)
    var movieResponse: Response,
    @Relation(
        entity = CastDb::class,
        parentColumn = "id",
        entityColumn = "id"
    )
    @TypeConverters(CastConverter::class)
    var cast : Cast
)
{
    constructor() : this(Response(MovieDbModel(0,"","","", Genres(0), 0)), Cast(CastDb()))
}


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
