package com.sigma.internship.mvvm.data.db.convertermodels

import androidx.room.Embedded
import com.sigma.internship.mvvm.data.db.entities.CastDb

data class Genres(
    @Embedded
    var genre_ids: Int

)

//  val genre_ids: ArrayList<Int> = arrayListOf()
