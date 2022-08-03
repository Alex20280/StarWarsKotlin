package com.sigma.internship.mvvm.data.db.convertermodels

import androidx.room.Embedded
import com.sigma.internship.mvvm.data.db.entities.CastDb
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

data class Cast(
    @Embedded
    var cast: CastDb
)

//val cast: ArrayList<CastDb> = arrayListOf()