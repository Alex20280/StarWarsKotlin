package com.sigma.internship.mvvm.data.db.convertermodels

import androidx.room.Embedded
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

data class Response(
    @Embedded
    var movieResponse: MovieDbModel

)
