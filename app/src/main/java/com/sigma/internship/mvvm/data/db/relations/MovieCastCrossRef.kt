package com.sigma.internship.mvvm.data.db.relations

import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

@Entity(
    tableName = "movie_cast",
    primaryKeys = ["movieIdMap","castIdMap"],
    foreignKeys = [
        /* A MovieId MUST be a value of an existing id column in the movie table */
        ForeignKey(
            entity = MovieDbModel::class,
            parentColumns = ["id"],
            childColumns = ["movieIdMap"],
            /* Optional (helps maintain referential integrity) */
            /* if parent is deleted then children rows of that parent are deleted */
            onDelete = ForeignKey.CASCADE,
            /* if parent column is changed then the column that references the parent is changed to the same value */
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CastDbModel::class,
            parentColumns = ["id"],
            childColumns = ["castIdMap"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class MovieCastCrossRef(
    var movieIdMap: Int,
    @ColumnInfo(index = true)
    var castIdMap: Int
)