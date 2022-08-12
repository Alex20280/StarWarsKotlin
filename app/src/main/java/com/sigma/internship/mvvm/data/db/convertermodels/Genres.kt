package com.sigma.internship.mvvm.data.db.convertermodels

import androidx.room.Embedded

data class Genres(
    @Embedded
    var id: Int,
    var name: String

)

//  val genre_ids: ArrayList<Int> = arrayListOf()
