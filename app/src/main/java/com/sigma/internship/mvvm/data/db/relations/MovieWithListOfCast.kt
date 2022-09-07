package com.sigma.internship.mvvm.data.db.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieCastCrossRef
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

data class MovieWithListOfCast(
    @Embedded /* The parent */
    val movie: CastDbModel,
    @Relation(
        entity = CastDbModel::class, /* The class of the related table(entity) (the children)*/
        parentColumn = "id", /* The column in the @Embedded class (parent) that is referenced/mapped to */
        entityColumn = "id", /* The column in the @Relation class (child) that is referenced (many-many) or references the parent (one(parent)-many(children)) */
        /* For the mapping table */
        associateBy = Junction(
            value = MovieCastCrossRef::class, /* The class of the mapping table */
            parentColumn = "movieIdMap", /* the column in the mapping table that maps/references the parent (@Embedded) */
            entityColumn = "castIdMap" /* the column in the mapping table that maps/references the child (@Relation) */
        )
    )
    val castList: List<CastDbModel>
)


/*
data class MovieWithListOfCast(
    @Embedded /* The parent */
    var movie: MovieDbModel,
    @Relation(
        entity = CastDbModel::class, /* The class of the related table(entity) (the children)*/
        parentColumn = "id", /* The column in the @Embedded class (parent) that is referenced/mapped to */
        entityColumn = "id", /* The column in the @Relation class (child) that is referenced (many-many) or references the parent (one(parent)-many(children)) */
        /* For the mapping table */
        associateBy = Junction(
            value = MovieCastCrossRef::class, /* The class of the mapping table */
            parentColumn = "castIdMap", /* the column in the mapping table that maps/references the parent (@Embedded) */
            entityColumn = "movieIdMap" /* the column in the mapping table that maps/references the child (@Relation) */
        )
    )
    var castList: List<CastDbModel>
)*/
