package com.sigma.internship.mvvm.data.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.sigma.internship.mvvm.data.db.entities.DetailsDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

data class MovieAndDetails (
    @Embedded
    val movie: MovieDbModel,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val details: DetailsDbModel

        )
